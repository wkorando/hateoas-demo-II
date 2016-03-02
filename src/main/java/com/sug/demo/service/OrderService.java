package com.sug.demo.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.sug.demo.model.Response;
import com.sug.demo.model.entity.Order;
import com.sug.demo.repo.OrderRepo;

@Service
public class OrderService {
	private Logger LOG = Logger.getLogger(OrderService.class);
	@Autowired
	private OrderRepo orderRepo;

	public Response<List<Order>> findOrdersByCustomerId(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Response<Order> findOrderForCustomerById(String id, String orderId) {
		Response<Order> response = new Response<>();
		try {
			Order order = orderRepo.findOne(Long.valueOf(orderId));
			if (order != null) {
				response.setResponseBody(order);
			} else {
				response.setHttpStatus(HttpStatus.NOT_FOUND);
			}

		} catch (Exception exception) {
			LOG.error("Error occurred while attempting to retrieve order:" + orderId, exception);
			response.setMessage("An error occurred while attempting to retrieve your order. Please try again later.");
			response.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return null;
	}

	public Response<Order> createNewOrder(String id, Order order) {
		Response<Order> response = new Response<>();
		try {
			response.setResponseBody(orderRepo.save(order));
		} catch (Exception exception) {
			LOG.error("Error occurred while attempting to save item: " + (order != null ? order.toString() : null),
					exception);
			response.setMessage("An error occurred while attempting to save item: "
					+ (order != null ? order.toString() : null) + " Verify your input or please try again later.");
			response.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	public Response<Order> updateOrder(String id, String orderId, Order order) {
		// TODO Auto-generated method stub
		return null;
	}

}
