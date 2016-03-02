package com.sug.demo.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.sug.demo.model.Response;
import com.sug.demo.model.entity.Order;
import com.sug.demo.model.entity.Payment;
import com.sug.demo.repo.OrderRepo;
import com.sug.demo.repo.PaymentRepo;
import com.sug.demo.utils.OrderUtils;

@Service
public class PaymentService {
	private Logger LOG = Logger.getLogger(PaymentService.class);
	@Autowired
	private PaymentRepo paymentRepo;
	@Autowired
	private OrderRepo orderRepo;

	public Response<String> payForOrder(String id, String orderId, Payment payment) {
		Response<String> response = new Response<>();
		Order order = orderRepo.findOne(Long.valueOf(orderId));
		payment.setOrder(order);
		payment.setAmount(OrderUtils.calculateOrderTotal(order));
		try {
			paymentRepo.save(payment);
			response.setResponseBody("SUCCESS");
		} catch (Exception e) {
			LOG.error("An error occurred while attempting to save the payment.");
			response.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setMessage("An error occurred while attempting to process your payment");
			response.setResponseBody("FAILURE");
		}
		return response;
	}

	public Response<Payment> viewPaymentForOrder(String id, String orderId, String paymentId) {
		Response<Payment> response = new Response<>();
		response.setResponseBody(paymentRepo.findOne(Long.valueOf(paymentId)));
		return response;
	}

}
