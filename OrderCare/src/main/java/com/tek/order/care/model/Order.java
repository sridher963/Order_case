package com.tek.order.care.model;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the complete list of orders
 * 
 * @author
 *
 */
public class Order {

	private List<OrderCart> orderCart = new ArrayList<OrderCart>();

	public void add(OrderCart order) throws Exception {
		if (order == null) {
			System.err.println("ERROR - Order is NULL");
			throw new IllegalArgumentException("Order is NULL");
		}
		orderCart.add(order);
	}

	public int size() {
		return orderCart.size();
	}

	public OrderCart get(int i) {
		return orderCart.get(i);
	}

	public void clear() {
		this.orderCart.clear();
	}

}
