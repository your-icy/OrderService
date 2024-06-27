package com.icycodes.orderservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Order_Details")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;

    @Column(name = "Product_Id")
    private Long productId;

    @Column(name = "Order_Date")
    private Instant orderDate;

    @Column(name = "Order_Status")
    private String orderStatus;

    @Column(name = "Quantity")
    private Long quantity;

    @Column(name = "Unit_Price")
    private Long unitPrice;

    @Column(name = "Total_Price")
    private Long totalPrice;

}
