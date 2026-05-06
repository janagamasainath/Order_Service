package com.example.demo.OrderApplicatiojApplication.service;

import com.example.demo.OrderApplicatiojApplication.common.Payment;
import com.example.demo.OrderApplicatiojApplication.common.TransactionRequest;
import com.example.demo.OrderApplicatiojApplication.common.TransactionResponse;
import com.example.demo.OrderApplicatiojApplication.model.Order;
import com.example.demo.OrderApplicatiojApplication.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private KafkaTemplate<String, Order> kafkaTemplate;

    private static final String TOPIC = "order-topic";

    private String url;

    public TransactionResponse saveOrder(TransactionRequest request) {


        String orderMessage = "";
        Order order = request.getOrder();
        Payment payment =request.getPayment();

        Order savedOrder = orderRepo.save(order);


        payment.setOrderId(savedOrder.getOrderId());
        payment.setAmount(savedOrder.getPrice());

        String url = "http://PAYMENT-SERVICE/payment/dopayment";
        Payment paymentResponse = restTemplate.postForObject(url, payment, Payment.class);

         orderMessage =
                paymentResponse.getPaymentStatus().equalsIgnoreCase("Success")
                        ? "Order placed successfully"
                        : "Payment failed, added to cart";

         return new TransactionResponse(
                savedOrder,
                paymentResponse.getAmount(),
                paymentResponse.getTransactionId(),
                orderMessage
        );
    }

    // for kafka data checking purpose
    public void sendOrder(TransactionRequest event) {
        kafkaTemplate.send(TOPIC, event.getOrder());
        System.out.println("Order sent: " + event);
    }
}
