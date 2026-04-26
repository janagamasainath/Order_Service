package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.Parent;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Patent;

@Service
public interface PatentService {
	
	public Patent savePatent(Patent patent);
	
	public List<Patent> getAllPatents();
	
	public Patent getPatentById(Integer Id);
	
	public void deletePatent(Integer Id);
	
	public List<Patent> findBasedOnArea();
	
	//public Patent updateProduct(Patent patent);

	//public Parent updateProduct(Integer id, Patent patent);

}
