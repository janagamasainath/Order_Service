package com.example.demo.exception;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.example.demo.entity.Patent;

import lombok.Data;

@Data
public class ExceptionResponse {
 private String message;
 private LocalDate date;
 private int id;


}