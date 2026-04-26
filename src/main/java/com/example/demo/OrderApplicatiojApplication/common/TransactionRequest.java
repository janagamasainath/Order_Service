package com.example.demo.OrderApplicatiojApplication.common;

import com.example.demo.OrderApplicatiojApplication.model.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TransactionRequest {

    private Order order;
    private Payment payment;
}
