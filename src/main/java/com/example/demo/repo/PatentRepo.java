package com.example.demo.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Patent;

@Repository
public interface PatentRepo extends JpaRepository<Patent, Integer>{
	
	@Query(value = " SELECT * FROM public.patents where city='Hyderabad' ", nativeQuery = true)
	public List<Patent> findBasedOnArea();

}
