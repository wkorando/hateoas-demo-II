package com.sug.demo.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Orders")
public class Order implements Serializable {
	private static final long serialVersionUID = -6335164270935973263L;
	@Id
	@Column(name = "id")
	private long id;
	@Column(name="status")
	private String status = "OPEN";
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	@ManyToMany
	@JoinTable(name = "Order_Items", joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id") , //
	inverseJoinColumns = @JoinColumn(name = "item_id", referencedColumnName = "id") ) //
	private List<Item> items;
	@OneToOne
	@JoinColumn(name = "payment_id")
	private Payment payment;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	@Override
	public String toString() {
		return "Order [id=" + id + ", status=" + status + ", customer=" + customer + ", items=" + items + ", payment="
				+ payment + "]";
	}

	
}
