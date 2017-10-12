package com.tek.order.care.orders;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.tek.order.care.constants.Constants;
import com.tek.order.care.model.Item;
import com.tek.order.care.model.Order;
import com.tek.order.care.model.OrderCart;
import com.tek.order.care.service.FileService;

/**
 * This class is responsible for preparing the order and providing the all order
 * list generated from reading the orders.csv
 * 
 * @author
 *
 */
public class GetOrders {

	private Map<String, Order> orders = new TreeMap<String, Order>();

	public Map<String, Order> getAllOrders() throws IOException, URISyntaxException {
		List<String> lines = FileService.readFileAsList(Constants.ORDERS_CSV);
		return getOrders(lines);
	}

	private Map<String, Order> getOrders(List<String> lines) {
		for (String line : lines) {
			if (line != null && !line.startsWith("#") && line.contains(",")) {
				String[] rowData = line.split(",");
				if (rowData != null && rowData.length == 4) {
					Order order = getOrder(rowData);
					if (order != null) {
						orders.put(rowData[0].trim(), order);
					}
				}
			}
		}
		return orders;
	}

	private Order getOrder(String[] cvsRowData) {
		Order order = null;
		try {
			if (orders.containsKey(cvsRowData[0].trim())) {
				order = orders.get(cvsRowData[0].trim());
			} else {
				order = new Order();
			}
			order.add(new OrderCart(new Item(cvsRowData[1].trim(), Float.parseFloat(cvsRowData[2].trim())), Integer.parseInt(cvsRowData[3].trim())));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return order;
	}

}
