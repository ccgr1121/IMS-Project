package com.qa.databases.services;

public interface CrudServices<T> {

	public String readAll();

	void create(T t);

	void update(T t);

	void delete(Long id);

	public void update(long item_id, String name, Double value, int stock);

}
