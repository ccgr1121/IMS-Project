package com.qa.databases.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.databases.persistence.Customer;
import com.qa.databases.persistence.Dao;


@RunWith(MockitoJUnitRunner.class)
public class CustomerServicesTest {

	@Mock
	private Dao<Customer> customerDao;

	@InjectMocks
	private CustomerServices customerServices;  

	@Test
	public void customerServicesCreate() {
		Customer customer = new Customer("chris", "perrins");
		customerServices.create(customer);
		Mockito.verify(customerDao, Mockito.times(1)).create(customer);
	}
 
	@Test
	public void customerServicesRead() {
		customerServices.readAll();
		Mockito.verify(customerDao, Mockito.times(1)).readAll();
	}

	@Test
	public void customerServicesUpdate() {
		Customer customer = new Customer("chris", "perrins");
		customerServices.update(1L, customer);
		Mockito.verify(customerDao, Mockito.times(1)).update(1L, customer);
	}

	@Test
	public void customerServicesDelete() {
		customerServices.delete(1L);
		;
		Mockito.verify(customerDao, Mockito.times(1)).delete(1L);
	}
}
