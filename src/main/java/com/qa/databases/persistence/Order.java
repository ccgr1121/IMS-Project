package com.qa.databases.persistence;

public class Order {

	private Long orderId;
	private Long fkCustomerId;
	private Double cost;

	public Order(Long orderId, Long fkCustomerId, Double cost) {
		this.orderId = orderId;
		this.fkCustomerId = fkCustomerId;
		this.cost = cost;
	}

	public Order(Long fkCustomerId, Double cost) {
		this.fkCustomerId = fkCustomerId;
		this.cost = cost;
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
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		return true;
	}

	
	
}
