package com.example.order_applicatioj.common;

import com.example.order_applicatioj.model.Order;
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
