package com.icycodes.orderservice.service;

import com.icycodes.orderservice.entity.Order;
import com.icycodes.orderservice.entity.OrderRepository;
import com.icycodes.orderservice.exceptions.CustomException;
import com.icycodes.orderservice.exceptions.OrderNotFoundException;
import com.icycodes.orderservice.external.client.PaymentService;
import com.icycodes.orderservice.external.client.ProductService;
import com.icycodes.orderservice.external.request.PaymentRequest;
import com.icycodes.orderservice.external.response.ProductResponse;
import com.icycodes.orderservice.model.OrderRequest;
import com.icycodes.orderservice.model.OrderResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Service
@Log4j2
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private PaymentService paymentService;


    @Autowired
    private RestTemplate restTemplate;



    @Override
    public Long placeOrder(OrderRequest orderRequest) {

        productService.reduceQuantity(
                orderRequest.getProductId(),
                orderRequest.getQuantity()
        );

        log.info("creating order with status - (CREATED)");

        Order order = Order.builder()
                .productId(orderRequest.getProductId())
                .quantity(orderRequest.getQuantity())
                .unitPrice((orderRequest.getTotalPrice())/(orderRequest.getQuantity()))
                .totalPrice(orderRequest.getTotalPrice())
                .orderDate(Instant.now())
                .orderStatus("CREATED")
                .build();


        order = orderRepository.save(order);
        log.info("created order with status - (CREATED)");

        PaymentRequest paymentRequest = PaymentRequest.builder()
                .orderId(order.getOrderId())
                .amount(orderRequest.getTotalPrice())
                .paymentMode(orderRequest.getPaymentMode())
                .referenceNumber(UUID.randomUUID().toString())
                .build();

        String orderStatus = null;

        try{
            log.info("trying payment");
            paymentService.doPayment(paymentRequest);
            log.info("payment successful");
            orderStatus = "PLACED";
        }catch (RuntimeException e){
            log.error("payment failed, changing order status to PAYMENT_FAILED");
            orderStatus = "PAYMENT_FAILED";
        }

        order.setOrderStatus(orderStatus);
        orderRepository.save(order);
        return order.getOrderId();

    }

    @Override
    public OrderResponse getOrderDetails(Long orderId) {

        log.info("starting finding orderId in the database");

        Order order = orderRepository.findById(orderId)
                .orElseThrow(
                () -> new OrderNotFoundException("Order not found for order id : " + orderId, "NOT_FOUND")
        );

        log.info("product with the id:{} found", orderId);

        // Rest template based fetch

        ProductResponse productResponse = restTemplate.getForObject(
                "Http://ProductService/product/" + order.getProductId(), ProductResponse.class);

        OrderResponse.ProductDetails productDetails = OrderResponse.ProductDetails.builder()
                .productName(productResponse.getProductName())
                .price(productResponse.getPrice())
                .productId(productResponse.getProductId())
                .quantity(productResponse.getQuantity())
                .build();

        OrderResponse orderResponse = OrderResponse.builder()
                .orderDate(order.getOrderDate())
                .orderId(order.getOrderId())
                .totalPrice(order.getTotalPrice())
                .orderStatus(order.getOrderStatus())
                .productDetails(productDetails)
                .build();

        log.info("returning product details");

        return orderResponse;
    }
}
