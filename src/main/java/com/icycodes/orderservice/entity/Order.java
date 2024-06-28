package com.icycodes.orderservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

import static jakarta.persistence.GenerationType.TABLE;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Order_Details")
public class Order {

    @TableGenerator(
            name = "orderGen",
            table = "ORDER_ID_GEN",
            pkColumnName = "GEN_KEY",
            valueColumnName = "GEN_VALUE",
            pkColumnValue = "ORDER_ID",
            allocationSize = 1)
    @Id
    @GeneratedValue(strategy=TABLE, generator="orderGen")
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
