  package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Patent;
import com.example.demo.exception.GlobalExceptionHandler;
import com.example.demo.exception.IdnotFoundException;
import com.example.demo.repo.PatentRepo;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PatentServiceImpl implements PatentService {
	@Autowired
	private PatentRepo patentRepo;

	@Autowired
	private GlobalExceptionHandler exceptionHandler;

	@Override
	public Patent savePatent(Patent patent) {
		// TODO Auto-generated method stub
		Patent savepatent = patentRepo.save(patent);
		return savepatent;
	}

	@Override
	public List<Patent> getAllPatents() {
		// TODO Auto-generated method stub
		List<Patent> findAll = patentRepo.findAll();
		return findAll;
	}

	@Override
	public Patent getPatentById(Integer Id) {
		// TODO Auto-generated method stub
		return patentRepo.findById(Id).orElseThrow(() -> new IdnotFoundException(Id));

	}

	@Override
	public void deletePatent(Integer Id) {
		// TODO Auto-generated method stub
		patentRepo.deleteById(Id);

	}

	@Override
	public List<Patent> findBasedOnArea() {
		// TODO Auto-generated method stub
		List<Patent> findBasedOnArea = patentRepo.findBasedOnArea();
		return findBasedOnArea;
	}

	

	

}
