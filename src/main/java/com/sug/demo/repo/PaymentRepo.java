package com.sug.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sug.demo.model.entity.Payment;

public interface PaymentRepo extends JpaRepository<Payment, Long> {

}
