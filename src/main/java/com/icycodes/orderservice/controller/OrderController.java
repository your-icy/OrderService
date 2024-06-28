package com.icycodes.orderservice.controller;

import com.icycodes.orderservice.model.OrderRequest;
import com.icycodes.orderservice.model.OrderResponse;
import com.icycodes.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/place_order")
    public ResponseEntity<Long> placeOrder(@RequestBody OrderRequest orderRequest){
        Long orderId = orderService.placeOrder(orderRequest);
        return new ResponseEntity<>(orderId, HttpStatus.CREATED);
    }

    @GetMapping("/get_order/{id}")
    public ResponseEntity<OrderResponse> getOrderDetails(@PathVariable("id") Long orderId){
        OrderResponse orderResponse = orderService.getOrderDetails(orderId);
        return new ResponseEntity<>(orderResponse,HttpStatus.FOUND);
    }



}
