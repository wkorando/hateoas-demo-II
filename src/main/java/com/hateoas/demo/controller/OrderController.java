package com.hateoas.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hateoas.demo.model.entity.Item;
import com.hateoas.demo.model.entity.Order;
import com.hateoas.demo.repo.OrderRepo;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderRepo orderRepo;

	@PreAuthorize("hasRole('USER')")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Resource<Order>> createNewOrder(@RequestBody Item item) {
		Resource<Order> order = new Resource<>(new Order());
//		order.getContent().addItem(item);
		orderRepo.save(order.getContent());
		// order.add(linkTo(methodOn(PaymentController.class).payForOrder(order.getContent())).withRel("payForOrder"));
		return ResponseEntity.ok(order);
	}

}