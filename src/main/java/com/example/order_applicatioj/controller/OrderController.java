package com.example.order_applicatioj.controller;

import com.example.order_applicatioj.common.Payment;
import com.example.order_applicatioj.common.TransactionRequest;
import com.example.order_applicatioj.common.TransactionResponse;
import com.example.order_applicatioj.model.Order;
import com.example.order_applicatioj.service.OrderService;
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


    @PostMapping("/bookorder")
    public TransactionResponse bookOrder(@RequestBody TransactionRequest request) {

       return orderService.saveOrder(request);


    }

}
