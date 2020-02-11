package com.qa.databases.services;

import com.qa.databases.persistence.Item;
import com.qa.databases.persistence.Dao;

public class ItemServices implements CrudServices<Item> {

	Dao<Item> itemDao;

	public ItemServices(Dao<Item> itemDao) {
		this.itemDao = itemDao;
	}

	@Override
	public void create(Item item) {
		itemDao.create(item);
	}

	@Override
	public String readAll() {
		return itemDao.readAll();
	}

	@Override
	public void update(Long id, Item t) {
		itemDao.update(id, t);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

}
