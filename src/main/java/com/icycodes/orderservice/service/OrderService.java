package com.icycodes.orderservice.service;

import com.icycodes.orderservice.model.OrderRequest;
import com.icycodes.orderservice.model.OrderResponse;

public interface OrderService {
    Long placeOrder(OrderRequest orderRequest);

    OrderResponse getOrderDetails(Long orderId);
}
