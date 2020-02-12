package com.qa.databases.services;

import com.qa.databases.persistence.Order;

import java.util.List;

import com.qa.databases.persistence.Dao;

public class OrderServices implements CrudServices<Order> {

	Dao<Order> orderDao;

	public OrderServices(Dao<Order> orderDao) {
		this.orderDao = orderDao;
	}

	@Override
	public Order create(Order order) {
		return orderDao.create(order);
	}

	@Override
	public List<Order> readAll() {
		return orderDao.readAll();
	}

	@Override
	public Order update(Long id, Order t) {
		return orderDao.update(id, t);

	}

	@Override
	public void delete(Long id) {
		orderDao.delete(id);

	}

}