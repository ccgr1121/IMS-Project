package com.qa.databases.services;

import java.util.List;

import com.qa.databases.domain.Item;
import com.qa.databases.persistence.Dao;
/**
 * This class implements the Item Class, and allows for interaction with the DAO.
 * @author Charlie Reddin
 *
 */
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
