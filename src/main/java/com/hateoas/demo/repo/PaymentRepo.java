package com.hateoas.demo.repo;

import org.springframework.data.repository.CrudRepository;

import com.hateoas.demo.model.entity.Payment;

public interface PaymentRepo extends CrudRepository<Payment, Long> {
}
