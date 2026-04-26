package com.example.order_applicatioj.common;

import com.example.order_applicatioj.model.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TransactionResponse {

    private Order order;
    private Double  price;
    private String transactionId;
    private String orderMessage;
}
