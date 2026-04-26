package com.example.demo.OrderApplicatiojApplication.repo;

import com.example.demo.OrderApplicatiojApplication.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<Order, Integer> {
}
