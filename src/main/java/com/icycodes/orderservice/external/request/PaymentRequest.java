package com.icycodes.orderservice.external.request;

import com.icycodes.orderservice.model.PaymentMode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentRequest {


    private String referenceNumber;

    private Long orderId;

    private Long amount;

    private PaymentMode paymentMode;


}
