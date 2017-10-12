package com.tek.order.care.orders;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.tek.order.care.model.Order;
import com.tek.order.care.model.OrderCart;
import com.tek.order.care.orders.GetOrders;

public class GetOrdersTest {

	private GetOrders getOrders = null;

	@Before
	public void init() {
		getOrders = new GetOrders();
	}

	@Test
	public void testGetOrders() throws Exception {
		Map<String, Order> orders = getOrders.getAllOrders();
		assertNotNull(orders);
		assertFalse(orders.isEmpty());
		assertTrue(orders.size() == 3);
		Order order1 = orders.get("Order 1");
		Order order2 = orders.get("Order 2");
		Order order3 = orders.get("Order 3");
		assertNotNull(order1);
		assertNotNull(order2);
		assertNotNull(order3);

		assertOrderOneItems(order1);
		assertOrderTwoItems(order2);
		assertOrderThreeItems(order3);

	}

	private void assertOrderOneItems(Order order) {
		OrderCart OrderCartItem1 = order.get(0);
		assertNotNull(OrderCartItem1);
		assertEquals("book", OrderCartItem1.getItem().getDescription());
		assertEquals(12.49, rounding(OrderCartItem1.getItem().getPrice()), 0);
		assertEquals(1, OrderCartItem1.getQuantity(), 0);

		OrderCart OrderCartItem2 = order.get(1);
		assertNotNull(OrderCartItem2);
		assertEquals("music CD", OrderCartItem2.getItem().getDescription());
		assertEquals(14.99, rounding(OrderCartItem2.getItem().getPrice()), 0);
		assertEquals(1, OrderCartItem2.getQuantity(), 0);

		OrderCart OrderCartItem3 = order.get(2);
		assertNotNull(OrderCartItem3);
		assertEquals("chocolate bar", OrderCartItem3.getItem().getDescription());
		assertEquals(0.85, rounding(OrderCartItem3.getItem().getPrice()), 0);
		assertEquals(1, OrderCartItem3.getQuantity(), 0);
	}

	private void assertOrderTwoItems(Order order) {
		OrderCart OrderCartItem1 = order.get(0);
		assertNotNull(OrderCartItem1);
		assertEquals("imported box of chocolate", OrderCartItem1.getItem().getDescription());
		assertEquals(10, rounding(OrderCartItem1.getItem().getPrice()), 0);
		assertEquals(1, OrderCartItem1.getQuantity(), 0);

		OrderCart OrderCartItem2 = order.get(1);
		assertNotNull(OrderCartItem2);
		assertEquals("imported bottle of perfume", OrderCartItem2.getItem().getDescription());
		assertEquals(47.50, rounding(OrderCartItem2.getItem().getPrice()), 0);
		assertEquals(1, OrderCartItem2.getQuantity(), 0);
	}

	private void assertOrderThreeItems(Order order) {
		OrderCart orderCartItem1 = order.get(0);
		assertNotNull(orderCartItem1);
		assertEquals("Imported bottle of perfume", orderCartItem1.getItem().getDescription());
		assertEquals(27.99, rounding(orderCartItem1.getItem().getPrice()), 0);
		assertEquals(1, orderCartItem1.getQuantity(), 0);

		OrderCart orderCartItem2 = order.get(1);
		assertNotNull(orderCartItem2);
		assertEquals("bottle of perfume", orderCartItem2.getItem().getDescription());
		assertEquals(18.99, rounding(orderCartItem2.getItem().getPrice()), 0);
		assertEquals(1, orderCartItem2.getQuantity(), 0);

		OrderCart orderCartItem3 = order.get(2);
		assertNotNull(orderCartItem3);
		assertEquals("packet of headache pills", orderCartItem3.getItem().getDescription());
		assertEquals(9.75, rounding(orderCartItem3.getItem().getPrice()), 0);
		assertEquals(1, orderCartItem3.getQuantity(), 0);

		OrderCart orderCartItem4 = order.get(3);
		assertNotNull(orderCartItem4);
		assertEquals("box of imported chocolates", orderCartItem4.getItem().getDescription());
		assertEquals(11.25, rounding(orderCartItem4.getItem().getPrice()), 0);
		assertEquals(1, orderCartItem4.getQuantity(), 0);
	}

	private double rounding(double value) {
		return Math.round(value * 100) / 100D;
	}

}
