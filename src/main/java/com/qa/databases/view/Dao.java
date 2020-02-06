package com.qa.databases.view;

import java.util.List;

public interface Dao<T>{
	//c
	public void create(T t);
	
	
	//r
	public List<T> readAll();
	
	
	//u
	public void update(T t);
	
	
	//d
	public void delete(int id);

}
