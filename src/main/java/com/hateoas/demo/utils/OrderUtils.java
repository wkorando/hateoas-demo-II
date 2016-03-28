package com.hateoas.demo.utils;

import com.hateoas.demo.model.entity.Item;
import com.hateoas.demo.model.entity.Order;

/**
 * Simple utility class for the Order entity.
 * 
 * @author williamkorando
 *
 */
public final class OrderUtils {
	private OrderUtils() {
	}

	public static double calculateOrderTotal(Order order) {
		double orderTotal = 0;
		for (Item item : order.getItems()) {
			orderTotal += item.getPrice();
		}
		return orderTotal;
	}
}
