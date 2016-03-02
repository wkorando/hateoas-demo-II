package com.sug.demo.utils;

import com.sug.demo.model.entity.Item;
import com.sug.demo.model.entity.Order;

public final class OrderUtils {
	private OrderUtils() {
	}

	public static double calculateOrderTotal(Order order){
		double orderTotal = 0;
		for(Item item: order.getItems()){
			orderTotal += item.getPrice();
		}
		return orderTotal;
	}
}
