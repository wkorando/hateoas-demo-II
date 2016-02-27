package com.sug.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sug.demo.model.entity.Order;

public interface OrderRepo extends JpaRepository<Order, Long> {

}
