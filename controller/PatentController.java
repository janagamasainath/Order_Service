package com.example.demo.controller;

import java.util.List;

import org.hibernate.annotations.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Patent;
import com.example.demo.exception.IdnotFoundException;
import com.example.demo.service.PatentService;

@RestController
public class PatentController {

	@Autowired
	private PatentService patentService;

	@PostMapping("/savepatent")
	public ResponseEntity<Patent> savePatent(@RequestBody Patent patent) {
		Patent savePatent = patentService.savePatent(patent);

		return new ResponseEntity<>(savePatent, HttpStatus.OK);

	}

	@GetMapping("/getallpatents")
	public ResponseEntity<List<Patent>> getAllPatents() {
		List<Patent> allPatents = patentService.getAllPatents();

		return new ResponseEntity<List<Patent>>(allPatents, HttpStatus.OK);

	}
	
	@GetMapping("/getpatent/{Id}")
	public ResponseEntity<Patent> getPatentById(@PathVariable Integer Id){
		
	 Patent patentById = patentService.getPatentById(Id);
	 if (patentById==null) {
		throw new IdnotFoundException(Id);
	}
		return new ResponseEntity(patentById,HttpStatus.OK);
		
	}
	@DeleteMapping("/deleteby/{Id}")
	public void deletePatentId(@PathVariable Integer Id){
		if (patentService.getPatentById(Id)==null) {
			throw new IdnotFoundException(Id);
		}else {
		patentService.deletePatent(Id);
		}
		
	}
	@GetMapping("/basedonarea")
	public ResponseEntity< List<Patent>> findBasedOnArea() {
		// TODO Auto-generated method stub
		List<Patent> findBasedOnArea = patentService.findBasedOnArea();
		return new ResponseEntity<List<Patent>>(findBasedOnArea,HttpStatus.OK);
	}
}
