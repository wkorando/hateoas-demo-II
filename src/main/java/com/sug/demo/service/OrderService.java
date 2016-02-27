package com.sug.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sug.demo.model.Response;
import com.sug.demo.model.entity.Order;

@Service
public class OrderService {

	public Response<List<Order>> findOrdersByCustomerId(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Response<List<Order>> findOrderForCustomerById(String id, String orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	public Response<Order> createNewOrder(String id, Order order) {
		// TODO Auto-generated method stub
		return null;
	}

	public Response<Order> updateOrder(String id, String orderId, Order order) {
		// TODO Auto-generated method stub
		return null;
	}

}
