package com.example.order_applicatioj.service;

import com.example.order_applicatioj.common.Payment;
import com.example.order_applicatioj.common.TransactionRequest;
import com.example.order_applicatioj.common.TransactionResponse;
import com.example.order_applicatioj.model.Order;
import com.example.order_applicatioj.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private RestTemplate restTemplate;


    private String url;

    public TransactionResponse saveOrder(TransactionRequest request) {
        String orderMessage = "";
        Order order = request.getOrder();
        Payment payment =request.getPayment();

        Order savedOrder = orderRepo.save(order);


        payment.setOrderId(savedOrder.getId());
        payment.setAmount(savedOrder.getPrice());

        String url = "http://PAYMENT-SERVICE/payment/dopayment";
        Payment paymentResponse = restTemplate.postForObject(url, payment, Payment.class);

         orderMessage =
                paymentResponse.getPaymetStatus().equalsIgnoreCase("Success")
                        ? "Order placed successfully"
                        : "Payment failed, added to cart";

        return new TransactionResponse(
                savedOrder,
                paymentResponse.getAmount(),
                paymentResponse.getTransactionId(),
                orderMessage
        );
    }
}
