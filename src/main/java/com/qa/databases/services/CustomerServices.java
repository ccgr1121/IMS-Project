package com.qa.databases.services;

import com.qa.databases.persistence.Customer;
import com.qa.databases.persistence.Dao;

public class CustomerServices implements CrudServices<Customer> {

	Dao<Customer> customerDao;

	public CustomerServices(Dao<Customer> customerDao) {
		this.customerDao = customerDao;
	}
	
	@Override
	public void create(Customer customer) {
		customerDao.create(customer);
	}
	
	@Override
	public String readAll() {
		return customerDao.readAll();
	}

	@Override
	public void update(Long id, Customer t) {
		customerDao.update(id, t);
	}

	@Override
	public void delete(Long id) {
		customerDao.delete(id);
	}


}
