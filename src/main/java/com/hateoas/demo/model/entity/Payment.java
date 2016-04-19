package com.hateoas.demo.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.hateoas.Identifiable;

/**
 * Simple example of tracking a payment a customer made.
 * 
 * @author williamkorando
 *
 */
@Entity
@Table(name = "Payments")
public class Payment implements Serializable, Identifiable<Long> {
	private static final long serialVersionUID = 1814253867183075738L;
	@Id
	@Column(name = "id")
	private Long id;
	@Column(name = "amount")
	private double amount;
	@OneToOne
	@JoinColumn(name = "order_id")
	private Order order;

	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
}
