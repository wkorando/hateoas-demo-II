package com.sug.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sug.demo.model.Response;
import com.sug.demo.model.entity.Customer;
import com.sug.demo.model.entity.Order;
import com.sug.demo.model.entity.Payment;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	@RequestMapping(value = "/{id}")
	public ResponseEntity<Customer> findCustomerById(@PathVariable("id") String id) {
		return null;
	}

	@RequestMapping("/{id}/orders")
	public ResponseEntity<List<Order>> findOrdersForCustomer(@PathVariable("id") String type) {
		return null;
	}

	@RequestMapping("/{id}/orders/{orderId}")
	public ResponseEntity<List<Order>> findOrderByIdForCustomer(@PathVariable("id") String id,
			@PathVariable("orderId") String orderId) {
		return null;
	}

	@RequestMapping(value = "/{id}/orders/", method = RequestMethod.POST)
	public ResponseEntity<List<Order>> createCustomerOrder(@PathVariable("id") String id, @RequestBody Order order) {
		return null;
	}

	@RequestMapping(value = "/{id}/orders/{orderId}", method = RequestMethod.PUT)
	public ResponseEntity<List<Order>> updateCustomerOrder(@PathVariable("id") String id,
			@PathVariable("orderId") String orderId, @RequestBody Order order) {
		return null;
	}

	@RequestMapping(value = "/{id}/orders/{orderId}/payment", method = RequestMethod.POST)
	public ResponseEntity<Response> payForOrder(@PathVariable("id") String id, @PathVariable("orderId") String orderId,
			@RequestBody Payment payment) {
		return null;
	}

	@RequestMapping(value = "/{id}/orders/{orderId}/payment/{paymentId}")
	public ResponseEntity<Payment> viewPaymentForOrder(@PathVariable("id") String id,
			@PathVariable("orderId") String orderId, @PathVariable("paymentId") String paymentId) {
		return null;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Response> addCustomer(@RequestBody Customer customer) {
		return null;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Response> updateCustomer(@PathVariable("id") String id, @RequestBody Customer customer) {
		return null;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Response> deleteCustomer(@PathVariable("id") String id) {
		return null;
	}
}
