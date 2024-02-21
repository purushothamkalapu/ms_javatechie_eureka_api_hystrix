package com.purushotham.orderservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PaymentDTO {

    private Integer paymentId;
    private String paymentStatus;
    private String transactionId;
    private int orderId;
    private double amount;

}