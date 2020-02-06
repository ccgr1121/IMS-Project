package com.qa.databases.view;

public class Orders {

	private long orders_id;
	private long fk_customer_id;
	private long fk_item_id;
	private long quantity;
	private long cost;

	public Orders(long orders_id, long fk_customer_id, long fk_item_id, long quantity, long cost) {
		this.orders_id = orders_id;
		this.fk_customer_id = fk_customer_id;
		this.fk_item_id = fk_item_id;
		this.quantity = quantity;
		this.cost = cost;
	}

	public long getId() {
		return orders_id;
	}

	public void setId(long id) {
		this.orders_id = id;
	}

	public long getFk_customer_id() {
		return fk_customer_id;
	}

	public void setFk_customer_id(long fk_customer_id) {
		this.fk_customer_id = fk_customer_id;
	}

	public long getFk_item_id() {
		return fk_item_id;
	}

	public void setFk_item_id(long fk_item_id) {
		this.fk_item_id = fk_item_id;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public long getCost() {
		return cost;
	}

	public void setCost(long cost) {
		this.cost = cost;
	}

}
