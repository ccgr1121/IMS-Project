package com.qa.databases.controller;

import org.apache.log4j.Logger;

import com.qa.databases.persistence.Customer;
import com.qa.databases.services.CrudServices;
import com.qa.databases.utils.Utils;

/**
 * Takes in customer details for CRUD functionality
 *
 */
public class CustomerController implements CrudController {

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
	public void readAll() {
		customerService.readAll();
		LOGGER.info("Current list of Customers:");
		LOGGER.info(customerService.readAll());
	}

	/**
	 * Creates a customer by taking in user input
	 */

	@Override
	public void create() {
		LOGGER.info("Please enter a first name");
		String firstName = Utils.getInput();
		LOGGER.info("Please enter a surname");
		String surname = Utils.getInput();
		customerService.create(new Customer(firstName, surname));
		LOGGER.info("Customer created");
	}

	/**
	 * Updates an existing customer by taking in user input
	 * 
	 * @return
	 */
	@Override

	public void update() {
		LOGGER.info("Please enter the ID of the customer whose details you wish to edit:");
		String stringID = Utils.getInput();
		long customerId = Long.parseLong(stringID);
		LOGGER.info("Please enter their new first name:");
		String firstName = Utils.getInput();
		LOGGER.info("Please enter their new last name:");
		String surname = Utils.getInput();
		customerService.update(customerId, new Customer(customerId, firstName, surname));
		LOGGER.info("Customer updated");
	}

	/**
	 * Deletes an existing customer by the id of the customer
	 */
	
	@Override

	public void delete() {
		LOGGER.info("Please enter the id of the customer you would like to delete");
		String stringId = Utils.getInput();
		long customerId = Long.parseLong(stringId);
		customerService.delete(customerId);
		LOGGER.info("Customer deleted successfully");
	}

}
