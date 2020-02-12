package com.qa.databases.services;

import com.qa.databases.persistence.Item;

import java.util.List;

import com.qa.databases.persistence.Dao;

public class ItemServices implements CrudServices<Item> {

	Dao<Item> itemDao;

	public ItemServices(Dao<Item> itemDao) {
		this.itemDao = itemDao;
	}

	@Override
	public Item create(Item item) {
		return itemDao.create(item);
	}

	@Override
	public List<Item> readAll() {
		return itemDao.readAll();
	}

	@Override
	public Item update(Long id, Item t) {
		return itemDao.update(id, t);
	}

	@Override
	public void delete(Long id) {
		itemDao.delete(id);

	}

}
