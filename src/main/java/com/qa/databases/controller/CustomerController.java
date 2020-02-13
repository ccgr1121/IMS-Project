package com.qa.databases.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.qa.databases.persistence.Customer;
import com.qa.databases.services.CrudServices;
import com.qa.databases.utils.Utils;

/**
 * Takes in customer details for CRUD functionality
 *
 */
public class CustomerController implements CrudController<Customer> {

	public static final Logger LOGGER = Logger.getLogger(CustomerController.class);

	private CrudServices<Customer> customerService;
 
	public CustomerController(CrudServices<Customer> customerService) {
		this.customerService = customerService;
	}

	String getInput() {
		return Utils.getInput();
	}
  
	/**
	 * Reads all customers to the logger
	 */

	@Override
	public List<Customer> readAll() {
		List<Customer> customers = customerService.readAll();
		for(Customer customer: customers) {
			LOGGER.info(customer.toString());
		}
		return customers;
	}

	/**
	 * Creates a customer by taking in user input
	 */

	@Override
	public Customer create() {
		LOGGER.info("Please enter a first name");
		String firstName = getInput();
		LOGGER.info("Please enter a surname");
		String surname = getInput();
		Customer customer = customerService.create(new Customer(firstName, surname));
		LOGGER.info("Customer created");
		return customer;
	}

	/**
	 * Updates an existing customer by taking in user input
	 * 
	 * @return
	 */
	@Override 

	public Customer update() {
		LOGGER.info("Please enter the ID of the customer whose details you wish to edit:");
		String stringID = getInput();
		long customerId = Long.parseLong(stringID);
		LOGGER.info("Please enter their new first name:");
		String firstName = getInput();
		LOGGER.info("Please enter their new last name:");
		String surname = getInput();
		Customer customer = customerService.update(customerId, new Customer(customerId, firstName, surname));
		LOGGER.info("Customer updated");
		return customer;
	}

	/**
	 * Deletes an existing customer by the id of the customer
	 */
	
	@Override

	public void delete() {
		LOGGER.info("Please enter the id of the customer you would like to delete");
		String stringId = getInput();
		long customerId = Long.parseLong(stringId);
		customerService.delete(customerId);
		LOGGER.info("Customer deleted successfully");
	}

}
