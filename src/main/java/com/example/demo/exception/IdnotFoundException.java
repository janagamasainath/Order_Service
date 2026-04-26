package com.example.demo.exception;

import java.time.LocalDate;

import lombok.Data;

@Data
public class IdnotFoundException extends RuntimeException{
 
 private int id;

public IdnotFoundException(int id) {
	super();
	this.id = id;
}
 
 

}
