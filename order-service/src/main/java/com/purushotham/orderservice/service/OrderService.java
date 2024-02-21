package com.purushotham.orderservice.service;

import com.purushotham.orderservice.dtos.PaymentDTO;
import com.purushotham.orderservice.entity.Order;
import com.purushotham.orderservice.repository.OrderRepository;
import com.purushotham.orderservice.request_responce.TransactionRequest;
import com.purushotham.orderservice.request_responce.TransactionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private RestTemplate restTemplate;

    public TransactionResponse saveOrder(TransactionRequest request){
        String response ="";
        Order order = request.getOrder();

        Order savedOrder = orderRepository.save(order);
        PaymentDTO paymentDTO = request.getPaymentDTO();
        paymentDTO.setOrderId(savedOrder.getId());
        paymentDTO.setAmount(order.getPrice());
        //REST call
        PaymentDTO paymentResponse = restTemplate.postForObject("http://localhost:8181/payment/doPayment ", paymentDTO, PaymentDTO.class);
        response = paymentResponse.getPaymentStatus().equals("success")?"Payment processing successfully and order placed":"there is failure in payment api,order added to cart";
        return new TransactionResponse(order, paymentResponse.getAmount(), paymentResponse.getTransactionId(), response);
    }

}
