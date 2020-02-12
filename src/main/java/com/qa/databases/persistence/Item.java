package com.qa.databases.persistence;

public class Item {

	private long itemId;
	private String name;
	private double value;
	private int stock;

	public Item(long itemId, String name, double value, int stock) {
		this.itemId = itemId;
		this.name = name;
		this.value = value;
		this.stock = stock;		
	}
	
	public Item(String name, double value, int stock) {
		this.name = name;
		this.value = value;
		this.stock = stock;	
	}

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

}