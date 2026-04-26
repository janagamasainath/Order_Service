package com.example.demo.OrderApplicatiojApplication.common;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data

public class Payment {


    private Integer payment_Id;
    private String transactionId;
    private String paymetStatus;

    private Integer orderId; // comes from order servide
    private Double amount; // comes from orders service

}
