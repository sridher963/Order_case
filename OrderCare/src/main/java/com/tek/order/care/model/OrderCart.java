package com.tek.order.care.model;

/**
 * This class represents an order cart which contains the @link Item and the
 * quantity.
 *
 * @author
 *
 */
public class OrderCart {

	private int quantity;
	private Item item;

	/**
	 * @param item
	 *            Item of the order
	 * @param quantity
	 *            Quantity of the item
	 * @throws Exception
	 */
	public OrderCart(Item item, int quantity) throws Exception {
		if (item == null) {
			System.err.println("ERROR - Item is NULL");
			throw new Exception("Item is NULL");
		}
		assert quantity > 0;
		this.item = item;
		this.quantity = quantity;
	}

	public Item getItem() {
		return item;
	}

	public int getQuantity() {
		return quantity;
	}

}
