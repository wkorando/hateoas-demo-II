package com.sug.demo.service;

import org.springframework.stereotype.Service;

import com.sug.demo.model.Response;
import com.sug.demo.model.entity.Payment;

@Service
public class PaymentService {

	public Response<String> payForOrder(String id, String orderId, Payment payment) {
		// TODO Auto-generated method stub
		return null;
	}

	public Response<Payment> viewPaymentForOrder(String id, String orderId, String paymentId) {
		// TODO Auto-generated method stub
		return null;
	}

}
