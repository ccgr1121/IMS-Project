package com.qa.databases.persistence;

public class Order {

	private long orderId;
	private long fkCustomerId;
	private double cost;

	public Order(long orderId, long fkCustomerId, double cost) {
		this.orderId = orderId;
		this.fkCustomerId = fkCustomerId;
		this.cost = cost;
	}

	public Order(long fkCustomerId, double cost) {
		this.fkCustomerId = fkCustomerId;
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

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	} 

	public String toString() {
		return "orders_id:" + orderId + ", fk_customer_id:" + fkCustomerId + ", cost:" + cost;
	}

	
	
}
