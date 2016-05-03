package com.hateoas.demo.repo;

import org.springframework.data.repository.CrudRepository;

import com.hateoas.demo.model.entity.Order;

public interface OrderRepo extends CrudRepository<Order, Long> {
	
}
