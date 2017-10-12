package com.tek.order.care;

import java.util.Map;

import com.tek.order.care.model.Order;
import com.tek.order.care.orders.GetOrders;
import com.tek.order.care.service.ICalculatorService;
import com.tek.order.care.service.OrderCalculatorService;

public class OrderApp {
	
	public static void main(String[] args) {
		try {
			GetOrders prepareOrders = new GetOrders();
			Map<String, Order> orders = prepareOrders.getAllOrders();
			if (orders != null && !orders.isEmpty()) {
				ICalculatorService calculator = new OrderCalculatorService();
				double grandTotal = calculator.calculate(orders);
				System.out.println("Sum of orders: " + grandTotal);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
