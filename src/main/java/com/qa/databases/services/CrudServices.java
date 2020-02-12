
package com.qa.databases.services;

import java.util.List;

public interface CrudServices<T> {

	List<T> readAll();

	T create(T t);

	T update(Long id, T t);

	void delete(Long id);
}