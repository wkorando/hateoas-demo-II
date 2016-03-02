package com.sug.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sug.demo.model.entity.Order;
import com.sug.demo.model.entity.Payment;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@RequestMapping(value="/{id}")
	public ResponseEntity<Order> findOrderById(@PathVariable("id") String id){
		return null;
	}
	
	@RequestMapping(value="/{id}/payment", method=RequestMethod.POST)
	public ResponseEntity<Order> payForOrder(@PathVariable("id") String id, @RequestBody Payment payment){
		return null;
	}
}
