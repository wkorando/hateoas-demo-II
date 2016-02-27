package com.sug.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.sug.demo.service.CustomerService;
import com.sug.demo.service.OrderService;
import com.sug.demo.service.PaymentService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private PaymentService paymentService;
	
	@RequestMapping(value = "/{id}")
	public ResponseEntity<Response<Customer>> findCustomerById(@PathVariable("id") String id) {
		Response<Customer> response = customerService.findCustomerById(id);
		ResponseEntity<Response<Customer>> responseEntity = new ResponseEntity<>(response, response.getHttpStatus());
		return responseEntity;
	}

	@RequestMapping("/{id}/orders")
	public ResponseEntity<Response<List<Order>>> findOrdersForCustomer(@PathVariable("id") String id) {
		Response<List<Order>> response = orderService.findOrdersByCustomerId(id);
		ResponseEntity<Response<List<Order>>> responseEntity = new ResponseEntity<>(response, response.getHttpStatus());
		return responseEntity;
	}

	@RequestMapping("/{id}/orders/{orderId}")
	public ResponseEntity<Response<List<Order>>> findOrderForCustomerById(@PathVariable("id") String id,
			@PathVariable("orderId") String orderId) {
		Response<List<Order>> response = orderService.findOrderForCustomerById(id, orderId);
		ResponseEntity<Response<List<Order>>> responseEntity = new ResponseEntity<>(response, response.getHttpStatus());
		return responseEntity;
	}

	@RequestMapping(value = "/{id}/orders/", method = RequestMethod.POST)
	public ResponseEntity<Response<Order>> createCustomerOrder(@PathVariable("id") String id,
			@RequestBody Order order) {
		Response<Order> response = orderService.createNewOrder(id, order);
		ResponseEntity<Response<Order>> responseEntity = new ResponseEntity<>(response, response.getHttpStatus());
		return responseEntity;
	}

	@RequestMapping(value = "/{id}/orders/{orderId}", method = RequestMethod.PUT)
	public ResponseEntity<Response<Order>> updateCustomerOrder(@PathVariable("id") String id,
			@PathVariable("orderId") String orderId, @RequestBody Order order) {
		Response<Order> response = orderService.updateOrder(id, orderId, order);
		ResponseEntity<Response<Order>> responseEntity = new ResponseEntity<>(response, response.getHttpStatus());
		return responseEntity;
	}

	@RequestMapping(value = "/{id}/orders/{orderId}/payment", method = RequestMethod.POST)
	public ResponseEntity<Response<String>> payForOrder(@PathVariable("id") String id,
			@PathVariable("orderId") String orderId, @RequestBody Payment payment) {
		Response<String> response = paymentService.payForOrder(id, orderId, payment);
		ResponseEntity<Response<String>> responseEntity = new ResponseEntity<>(response, response.getHttpStatus());
		return responseEntity;
	}

	@RequestMapping(value = "/{id}/orders/{orderId}/payment/{paymentId}")
	public ResponseEntity<Response<Payment>> viewPaymentForOrder(@PathVariable("id") String id,
			@PathVariable("orderId") String orderId, @PathVariable("paymentId") String paymentId) {
		Response<Payment> response = paymentService.viewPaymentForOrder(id, orderId, paymentId);
		ResponseEntity<Response<Payment>> responseEntity = new ResponseEntity<>(response, response.getHttpStatus());
		return responseEntity;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Response<Customer>> createCustomer(@RequestBody Customer customer) {
		Response<Customer> response = customerService.createCustomer(customer);
		ResponseEntity<Response<Customer>> responseEntity = new ResponseEntity<>(response, response.getHttpStatus());
		return responseEntity;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Response<Customer>> updateCustomer(@PathVariable("id") String id,
			@RequestBody Customer customer) {
		Response<Customer> response = customerService.updateCustomer(id, customer);
		ResponseEntity<Response<Customer>> responseEntity = new ResponseEntity<>(response, response.getHttpStatus());
		return responseEntity;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Response<String>> deleteCustomer(@PathVariable("id") String id) {
		Response<String> response = customerService.deleteCustomer(id);
		ResponseEntity<Response<String>> responseEntity = new ResponseEntity<>(response, response.getHttpStatus());	
		return responseEntity;
	}
}
