package com.tek.order.care.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.tek.order.care.model.Item;
import com.tek.order.care.model.Order;
import com.tek.order.care.model.OrderCart;

public class OrderTest {

	private Order order;

	@Before
	public void init() {
		order = new Order();
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddOrderForIllegalArgument() throws Exception {
		order.add(null);
	}

	@Test
	public void testAddOrderForValidArgument() throws Exception {
		order.add(new OrderCart(new Item("test", 0), 1));
		assertEquals(1, order.size(), 0);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testGetOrder() {
		order.get(0);
	}

	@Test
	public void testOrderSize() throws Exception {
		assertEquals(0, order.size(), 0);
	}

	@Test
	public void testClearOrder() throws Exception {
		order.add(new OrderCart(new Item("test", 0), 1));
		assertEquals(1, order.size(), 0);
		order.clear();
		assertEquals(0, order.size(), 0);
	}

}
