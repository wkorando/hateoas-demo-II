package com.hateoas.demo.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.hateoas.Identifiable;

/**
 * Simple example of an item to be sold.
 * 
 * @author williamkorando
 *
 */
@Entity
@Table(name = "Items")
public class Item implements Serializable, Identifiable<Long> {
	private static final long serialVersionUID = -2587993829804340097L;
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "description")
	private String description;
	@Column(name = "price")
	private double price;
	@Column(name = "type")
	private String type;
	/**
	 * We don't want to show this field to the outside world. It's secret!
	 */
	@Column(name = "secret_field")
	@RestResource(exported = false)
	private String secretField;

	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSecretField() {
		return secretField;
	}

	public void setSecretField(String secretField) {
		this.secretField = secretField;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + ", type="
				+ type + "]";
	}
}
