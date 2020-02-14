package com.qa.databases.services;

import java.util.List;

import com.qa.databases.domain.Order;
import com.qa.databases.persistence.Dao;
/**
 * This class implements the Order Class, and allows for interaction with the DAO.
 * @author Charlie Reddin
 *
 */
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