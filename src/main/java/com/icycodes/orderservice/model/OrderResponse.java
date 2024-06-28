package com.icycodes.orderservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {

    private Long orderId;

    private String orderStatus;

    private Long totalPrice;

    private Instant orderDate;

    private ProductDetails productDetails;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ProductDetails {

        private String productName;

        private Long productId;

        private Long price;

        private Long quantity;

    }

}
