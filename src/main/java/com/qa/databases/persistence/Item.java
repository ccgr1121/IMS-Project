package com.qa.databases.persistence;

public class Item {

	private long item_id;
	private String name;
	private double value;
	private int stock;

	public Item(long item_id, String name, double value, int stock) {
		this.item_id = item_id;
		this.name = name;
		this.value = value;
		this.stock = stock;		
	}
	
	public Item(String name, double value, int stock) {
		this.name = name;
		this.value = value;
		this.stock = stock;	
	}

	public long getItem_id() {
		return item_id;
	}

	public void setItem_id(long item_id) {
		this.item_id = item_id;
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
