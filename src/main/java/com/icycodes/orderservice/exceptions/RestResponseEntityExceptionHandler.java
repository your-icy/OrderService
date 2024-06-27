package com.icycodes.orderservice.exceptions;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

//    @ExceptionHandler(ProductNotFoundException.class)
//    public ResponseEntity<ErrorResponse> handleProductNotFoundException(ProductNotFoundException exception){
//        return new ResponseEntity<>(ErrorResponse.builder()
//                .errorCode(exception.getErrorCode())
//                .errorMessage(exception.getMessage())
//                .build(), HttpStatus.NOT_FOUND);
//    }
}
