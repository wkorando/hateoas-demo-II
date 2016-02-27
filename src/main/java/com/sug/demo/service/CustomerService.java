package com.sug.demo.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.sug.demo.model.Response;
import com.sug.demo.model.entity.Customer;
import com.sug.demo.repo.CustomerRepo;

@Service
public class CustomerService {
	private Logger LOG = Logger.getLogger(CustomerService.class);
	@Autowired
	private CustomerRepo customerRepo;

	public Response<Customer> createCustomer(Customer customer) {
		Response<Customer> response = new Response<>();
		try {
			customerRepo.save(customer);
		} catch (Exception exception) {
			LOG.error("Error occurred while attempting to save customer: "
					+ (customer != null ? customer.toString() : null), exception);
			response.setMessage("An error occurred while attempting to save customer: "
					+ (customer != null ? customer.toString() : null)
					+ ". Verify your input or please try again later.");
			response.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	public Response<Customer> updateCustomer(String id, Customer customer) {
		Response<Customer> response = new Response<>();
		try {
			Long longId = Long.valueOf(id);
			if (customerRepo.exists(longId)) {
				customer.setId(longId);
				response.setResponseBody(customerRepo.save(customer));
			} else {
				response.setMessage("An customer with id " + id + " does not exist.");
				response.setHttpStatus(HttpStatus.NOT_FOUND);
			}
		} catch (Exception exception) {
			LOG.error("Error occurred while attempting to save customer: "
					+ (customer != null ? customer.toString() : null), exception);
			response.setMessage("An error occurred while attempting to update customer: "
					+ (customer != null ? customer.toString() : null)
					+ ". Verify your input or please try again later.");
			response.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}
	
	public Response<Customer> findCustomerById(String id) {
		Response<Customer> response = new Response<>();
		try {
			Long longId = Long.valueOf(id);
			if (customerRepo.exists(longId)) {
				response.setResponseBody(customerRepo.findOne(longId));
			} else {
				response.setMessage("An customer with id " + id + " does not exist.");
				response.setHttpStatus(HttpStatus.NOT_FOUND);
			}
		} catch (Exception exception) {
			LOG.error("An error occurred while attempting to retrieve customer with id of:" +
					id, exception);
			response.setMessage("An error occurred while attempting to retrieve customer with id of:" +
					id + ". Verify your input or please try again later.");
			response.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	public Response<String> deleteCustomer(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
