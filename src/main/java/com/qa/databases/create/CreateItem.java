package com.qa.databases.create;

public class CreateItem {
	private Long item_id;
	private String name;
	private double value;
	private int stock;

	public CreateItem(Long item_id, String name, double value, int stock) {
		this.item_id = item_id;
		this.name = name;
		this.value = value;
		this.stock = stock;
	}

	public Long getItem_id() {
		return item_id;
	}

	public void setItem_id(Long item_id) {
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
