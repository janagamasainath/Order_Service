package com.example.demo.OrderApplicatiojApplication.controller;

import com.example.demo.OrderApplicatiojApplication.common.TransactionRequest;
import com.example.demo.OrderApplicatiojApplication.common.TransactionResponse;
import com.example.demo.OrderApplicatiojApplication.model.Order;
import com.example.demo.OrderApplicatiojApplication.service.OrderService;
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

    @PostMapping
    public String placeOrder(@RequestBody TransactionRequest event) {
//       / event.set("CREATED");
        orderService.sendOrder(event);
        return "Order placed successfully";
    }

}
