package com.example.order_applicatioj.common;


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

    private Integer order_Id; // comes from order servide
    private Double amount; // comes from orders service

}
