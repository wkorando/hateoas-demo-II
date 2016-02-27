package com.sug.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sug.demo.model.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Long> {

}
