package com.hateoas.demo.model;

import org.springframework.data.rest.core.config.Projection;

import com.hateoas.demo.model.entity.Item;

@Projection(name = "itemSummary", types = { Item.class })
public interface ItemSummary {
	String getName();
	String getPrice();
}
