package com.icycodes.orderservice.service;

import com.icycodes.orderservice.model.OrderRequest;

public interface OrderService {
    Long placeOrder(OrderRequest orderRequest);
}
