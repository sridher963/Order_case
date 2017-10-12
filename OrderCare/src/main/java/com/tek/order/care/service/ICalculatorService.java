package com.tek.order.care.service;

import java.util.Map;

import com.tek.order.care.model.Order;

/**
 * @author 
 *
 */
public interface ICalculatorService {

	public double calculate(Map<String, Order> orders);

}
