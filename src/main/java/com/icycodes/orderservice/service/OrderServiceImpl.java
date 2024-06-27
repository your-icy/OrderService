package com.icycodes.orderservice.service;

import com.icycodes.orderservice.entity.Order;
import com.icycodes.orderservice.entity.OrderRepository;
import com.icycodes.orderservice.external.client.ProductService;
import com.icycodes.orderservice.model.OrderRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Log4j2
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductService productService;


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

        return order.getOrderId();

    }
}
