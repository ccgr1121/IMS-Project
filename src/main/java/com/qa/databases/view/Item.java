package com.qa.databases.view;

public class Item {

	private Long item_id;
	private String name;
	private long value;
	private int stock;

	public Item(Long item_id, String name, long value, int stock) {
		this.item_id = item_id;
		this.name = name;
		this.value = value;
		this.stock = stock;

	}

	public Long getId() {
		return item_id;
	}

	public void setId(Long id) {
		this.item_id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getValue() {
		return value;
	}

	public void setValue(long value) {
		this.value = value;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
}
