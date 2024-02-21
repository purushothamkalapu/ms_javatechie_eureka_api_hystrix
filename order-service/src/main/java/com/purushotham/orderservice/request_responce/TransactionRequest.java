package com.purushotham.orderservice.request_responce;

import com.purushotham.orderservice.dtos.PaymentDTO;
import com.purushotham.orderservice.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequest {
    private PaymentDTO paymentDTO;
    private Order order;
}
