package com.tek.order.care.model;

/**
 * This class represents an item, contains a price and a description.
 * 
 * @author
 *
 */
public class Item {

	private String description;
	private float price;

	public Item(String description, float price) {
		super();
		this.description = description;
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public float getPrice() {
		return price;
	}

}
