package com.tek.order.care.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.tek.order.care.model.Item;
import com.tek.order.care.model.OrderCart;

public class OrderCartTest {

	@Test(expected = Exception.class)
	public void testOrderCartForllegalArgument() throws Exception {
		new OrderCart(null, 0);
	}

	@Test
	public void testOrderCartForQuantity() throws Exception {
		OrderCart orderCart = new OrderCart(new Item("test", 0), 1);
		assertEquals(1, orderCart.getQuantity(), 0);
	}

	@Test
	public void testOrderCartForItemPriceAndDescription() throws Exception {
		OrderCart orderCart = new OrderCart(new Item("test", 10), 1);
		assertNotNull(orderCart);
		assertNotNull(orderCart.getItem());
		assertEquals("test", orderCart.getItem().getDescription());
		assertEquals(10, orderCart.getItem().getPrice(), 0);
	}

}
