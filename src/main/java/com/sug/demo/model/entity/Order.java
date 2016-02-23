package com.sug.demo.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Orders")
public class Order {
	@Column(name = "id")
	private long id;
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	@ManyToMany
	@JoinTable(name = "Order_Items", 
	joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id") ,//
	inverseJoinColumns = @JoinColumn(name = "item_id", referencedColumnName = "id") )//
	private List<Item> items;
	@OneToOne
	@JoinColumn(name="payment_id")
	private Payment payment;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
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
