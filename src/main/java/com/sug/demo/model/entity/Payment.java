package com.sug.demo.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Payments")
public class Payment implements Serializable {
	private static final long serialVersionUID = -7041692600263236998L;
	@Id
	@Column(name = "id")
	private long id;
	@Column(name = "amount")
	private double amount;
	@OneToOne
	@JoinColumn(name = "order_id")
	private Order order;

	public long getId() {
		return id;
	}

	public void setId(long id) {
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
