package com.example.demo.exception;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.entity.Patent;
import com.example.demo.service.PatentService;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	
	
	@ExceptionHandler(value = EntityNotFoundException.class)
	public ResponseEntity<String> datafound(){
		String msg="no data fount with this id  ";
		return new ResponseEntity<String>(msg, HttpStatus.NOT_FOUND);
		
		
	    
	}

	@ExceptionHandler(IdnotFoundException.class)
    public ResponseEntity<Object> handleExceptions(IdnotFoundException exception) {
        ExceptionResponse response = new ExceptionResponse();
       
        response.setDate(LocalDate.now());
        response.setMessage("not found the data with this Id");
  
   
        ResponseEntity<Object> entity = new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        return entity;

}
}
