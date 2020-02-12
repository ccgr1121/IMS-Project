package com.qa.databases.services;

import com.qa.databases.persistence.Order;
import com.qa.databases.persistence.Dao;

public class OrderServices implements CrudServices<Order> {

	Dao<Order> orderDao;

	public OrderServices(Dao<Order> orderDao) {
		this.orderDao = orderDao;
	}

	@Override
	public void create(Order order) {
		orderDao.create(order);
	}

	@Override
	public String readAll() {
		return orderDao.readAll();
	}

	@Override
	public void update(Long id, Order t) {
		orderDao.update(id, t);

	}

	@Override
	public void delete(Long id) {
		orderDao.delete(id);

	}

}