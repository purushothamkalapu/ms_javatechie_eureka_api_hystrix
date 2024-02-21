package com.purushotham.orderservice.controller;

import com.purushotham.orderservice.dtos.PaymentDTO;
import com.purushotham.orderservice.entity.Order;
import com.purushotham.orderservice.request_responce.TransactionRequest;
import com.purushotham.orderservice.request_responce.TransactionResponse;
import com.purushotham.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @PostMapping("/bookOrder")
    public TransactionResponse bookOrder(@RequestBody TransactionRequest request){
        return orderService.saveOrder(request);
    }
}
