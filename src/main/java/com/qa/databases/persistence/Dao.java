package com.qa.databases.persistence;

public interface Dao<T> {

    String readAll();
     
    void create(T t);
     
    void update(long id, T t);

	void delete(long id);
}
	