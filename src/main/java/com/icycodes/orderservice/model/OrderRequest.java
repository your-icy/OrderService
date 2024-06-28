package com.icycodes.orderservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {

    private Long productId;

    private Long quantity;

    private Long totalPrice;

    private PaymentMode paymentMode;


}
