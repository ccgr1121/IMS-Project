package com.qa.databases.services;

import com.qa.databases.persistence.Customer;
import com.qa.databases.persistence.Dao;

public class CustomerServices implements CrudServices<Customer> {

	Dao<Customer> customerDao;

	public CustomerServices(Dao<Customer> customerDao) {
		this.customerDao = customerDao;
	}

	public String readAll() {
		return customerDao.readAll();
	}

	public void create(Customer customer) {
		customerDao.create(customer);
	}

	public void update(long id, Customer t) {
		customerDao.update(id, t);
	}

	public void delete(Customer t) {

	}

	@Override
	public void update(Customer t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(long item_id, String name, Double value, int stock) {
		// TODO Auto-generated method stub
		
	}

}
