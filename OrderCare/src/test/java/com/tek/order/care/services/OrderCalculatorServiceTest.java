package com.tek.order.care.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.tek.order.care.model.Order;
import com.tek.order.care.orders.GetOrders;
import com.tek.order.care.service.ICalculatorService;
import com.tek.order.care.service.OrderCalculatorService;

public class OrderCalculatorServiceTest {

	private GetOrders getOrders = null;
	private ICalculatorService calculatorService = null;

	@Before
	public void init() {
		getOrders = new GetOrders();
		calculatorService = new OrderCalculatorService();
	}

	@Test
	public void testCalculate() throws Exception {
		Map<String, Order> orders = getOrders.getAllOrders();
		assertNotNull(orders);
		assertFalse(orders.isEmpty());
		double total = calculatorService.calculate(orders);
		assertEquals(153.81, total, 0);
	}

}
