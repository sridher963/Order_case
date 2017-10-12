package com.tek.order.care.service;

import java.util.Map;

import com.tek.order.care.constants.Constants;
import com.tek.order.care.model.Order;

/**
 * This class is responsible doing the calculation of the order based on the
 * item price and quantity
 * 
 * @author
 *
 */
public class OrderCalculatorService implements ICalculatorService{

	/**
	 * It receives a collection of orders. For each order, iterates on the order
	 * lines and calculate the total price which is the item's price * quantity
	 * * taxes.
	 * 
	 * For each order, print the total Sales Tax paid and Total price without
	 * taxes for this order
	 */
	public double calculate(Map<String, Order> orders) {
		double grandtotal = 0;
		// Iterate through the orders
		for (Map.Entry<String, Order> entry : orders.entrySet()) {
			System.out.println("*******" + entry.getKey() + "*******");
			Order order = entry.getValue();
			double totalTax = 0;
			double total = 0;
			for (int i = 0; i < order.size(); i++) {
				double tax = 0;
				if (order.get(i).getItem().getDescription().contains(Constants.ITEM_IMPORED_SMALL) || order.get(i).getItem().getDescription().contains(Constants.ITEM_IMPORED_INIT_CAP)) {
					tax = getTaxForImportedItem(order.get(i).getItem().getPrice());
					// imported items
				} else {
					tax = getTaxForNonImportedItem(order.get(i).getItem().getPrice());
				}

				// Calculate the total price
				double totalprice = rounding(order.get(i).getItem().getPrice() + rounding(tax));
				System.out.println(order.get(i).getQuantity() + " " + order.get(i).getItem().getDescription() + ": " + totalprice);
				totalTax += tax;
				total += order.get(i).getItem().getPrice();
			}

			// Print out the total taxes
			System.out.println("Sales Tax: " + rounding(totalTax));
			// total = total + totalTax;

			// Print out the total amount
			System.out.println("Total: " + rounding(total * 100) / 100);
			grandtotal += total;
		}
		return rounding(grandtotal * 100) / 100;
	}

	private double getTaxForImportedItem(float itemPrice) {
		return itemPrice * Constants.TAX_IMPORTED_ITEM;
	}

	private double getTaxForNonImportedItem(float itemPrice) {
		return itemPrice * Constants.TAX_NON_IMPORTED_ITEM;
	}

	private double rounding(double value) {
		return Math.round(value * 100) / 100D;
	}
}
