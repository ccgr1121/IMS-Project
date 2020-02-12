package com.qa.databases.services;

public interface CrudServices<T> {

	public String readAll();

	void create(T t);

	void update(Long id, T t);

	void delete(Long id);
}
