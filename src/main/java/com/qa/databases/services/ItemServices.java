package com.qa.databases.services;

import com.qa.databases.persistence.Item;
import com.qa.databases.persistence.Dao;

public class ItemServices implements CrudServices<Item> {

	Dao<Item> itemDao;

	public ItemServices(Dao<Item> itemDao) {
		this.itemDao = itemDao;
	}

	public String readAll() {
		return itemDao.readAll(); 
	}

	public void create(Item item) {
		itemDao.create(item);
	}

	public void update(long id, Item t) {
		itemDao.update(id, t);
	}

	public void delete(Item t) {

	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(long item_id, String name, Double value, int stock) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Item t) {
		// TODO Auto-generated method stub
		
	}


}
