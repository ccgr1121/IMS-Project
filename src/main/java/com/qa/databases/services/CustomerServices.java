package com.qa.databases.services;

import java.util.List;

import com.qa.databases.domain.Customer;
import com.qa.databases.persistence.Dao;
/**
 * This class implements the Customer Class, and allows for interaction with the DAO.
 * @author Charlie Reddin
 *
 */
public class CustomerServices implements CrudServices<Customer> {

	Dao<Customer> customerDao;

	public CustomerServices(Dao<Customer> customerDao) {
		this.customerDao = customerDao;
	}
	
	@Override
	public Customer create(Customer customer) {
		return customerDao.create(customer);
	}
	 
	@Override
	public List<Customer> readAll() {
		return customerDao.readAll();
	}

	@Override
	public Customer update(Long id, Customer t) {
		return customerDao.update(id, t);
	}

	@Override 
	public void delete(Long id) {
		customerDao.delete(id);
	}



}
