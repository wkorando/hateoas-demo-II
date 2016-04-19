package com.hateoas.demo.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.hateoas.Identifiable;

/**
 * Simple example of a Order (Cart) implementation.
 * 
 * @author williamkorando
 *
 */
@Entity
@Table(name = "Orders")
public class Order implements Serializable, Identifiable<Long> {
	private static final long serialVersionUID = -7100263602279291309L;
	@Id
	@Column(name = "id")
	private Long id;
	@Column(name = "status")
	private String status = "OPEN";
	@ManyToMany
	@JoinTable(name = "Order_Items", joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id") , //
	inverseJoinColumns = @JoinColumn(name = "item_id", referencedColumnName = "id") ) //
	private List<Item> items = new ArrayList<>();
	@OneToOne
	@JoinColumn(name = "payment_id")
	private Payment payment;

	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

}
