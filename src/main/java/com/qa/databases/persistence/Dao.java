package com.qa.databases.persistence;

import java.util.List;

public interface Dao<T> {

    List<T> readAll();
     
    T create(T t);
     
    T update(long id, T t);

	void delete(long id);
}
	