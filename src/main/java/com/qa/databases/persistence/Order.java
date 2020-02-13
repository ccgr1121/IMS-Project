package com.qa.databases.persistence;

import java.util.ArrayList;

public class Order {

	private Long orderId;
	private Long fkCustomerId;
	private double discount;
	private Double cost;
	ArrayList<Item> itemList;

	public void setItemList(ArrayList<Item> itemList) {
		this.itemList = itemList;
	}
	public Order(Long orderId, Long fkCustomerId, Double cost) {
		this.orderId = orderId;
		this.fkCustomerId = fkCustomerId;
		this.cost = cost;
	}

	public Order(Long fkCustomerId, Double cost) {
		this.fkCustomerId = fkCustomerId;
		this.cost = cost;
	}

	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public Order(Long fkCustomerId, ArrayList<Item> itemList) {
		this.fkCustomerId = fkCustomerId;
		this.itemList = itemList;
	}

	public ArrayList<Item> getItemList() {
		return itemList;
	}
	
	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getFkCustomerId() {
		return fkCustomerId;
	}

	public void setFkCustomerId(Long fkCustomerId) {
		this.fkCustomerId = fkCustomerId;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cost == null) ? 0 : cost.hashCode());
		result = prime * result + ((fkCustomerId == null) ? 0 : fkCustomerId.hashCode());
		result = prime * result + ((itemList == null) ? 0 : itemList.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (cost == null) {
			if (other.cost != null)
				return false;
		} else if (!cost.equals(other.cost))
			return false;
		if (fkCustomerId == null) {
			if (other.fkCustomerId != null)
				return false;
		} else if (!fkCustomerId.equals(other.fkCustomerId))
			return false;
		if (itemList == null) {
			if (other.itemList != null)
				return false;
		} else if (!itemList.equals(other.itemList))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		return true;
	} 



	
	
}
