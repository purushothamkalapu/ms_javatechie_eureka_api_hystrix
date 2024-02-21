package com.purushotham.orderservice.request_responce;

import com.purushotham.orderservice.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TransactionResponse {
    private Order order;
    private double amount;
    private String transactionId;
    private String message;
}
