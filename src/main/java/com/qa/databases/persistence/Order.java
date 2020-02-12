package com.qa.databases.persistence;

public class Order {

	private long orderId;
	private long fkCustomerId;
	private long fkItemId;
	private int quantity;
	private double cost;

	public Order(long orderId, long fkCustomerId, long fkItemId, int quantity, double cost) {
		this.orderId = orderId;
		this.fkCustomerId = fkCustomerId;
		this.fkItemId = fkItemId;
		this.quantity = quantity;
		this.cost = cost;
	}

	public Order(long fkCustomerId, long fkItemId, int quantity, double cost) {
		this.fkCustomerId = fkCustomerId;
		this.fkItemId = fkItemId;
		this.quantity = quantity;
		this.cost = cost;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public long getFkCustomerId() {
		return fkCustomerId;
	}

	public void setFkCustomerId(long fkCustomerId) {
		this.fkCustomerId = fkCustomerId;
	}

	public long getFkItemId() {
		return fkItemId;
	}

	public void setFkItemId(long fkItemId) {
		this.fkItemId = fkItemId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

}
