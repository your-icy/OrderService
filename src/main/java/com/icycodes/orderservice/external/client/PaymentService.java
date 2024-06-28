package com.icycodes.orderservice.external.client;

import com.icycodes.orderservice.exceptions.CustomException;
import com.icycodes.orderservice.external.request.PaymentRequest;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CircuitBreaker(name = "external", fallbackMethod = "fallback")
@FeignClient(name = "PaymentService/pay")
public interface PaymentService {

    @PostMapping
    public ResponseEntity<Long> doPayment(@RequestBody PaymentRequest paymentRequest);

    default void fallback(){
        throw new CustomException(
                "Payment Service is down",
                "NOT_AVAILABLE",
                500
        );
    }


}
