package com.qa.databases.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.qa.databases.domain.Order;
import com.qa.databases.services.CrudServices;
import com.qa.databases.utils.Utils;

/**
 * Takes in customer details for CRUD functionality
 *
 */
public class OrderController implements CrudController<Order> {

	public static final Logger LOGGER = Logger.getLogger(OrderController.class);

	private CrudServices<Order> orderService;

	public OrderController(CrudServices<Order> orderService) {
		this.orderService = orderService;
	}

	String getInput() { 
		return Utils.getInput();
	}
	/**
	 * Reads all orders to the logger
	 */

	@Override
	public List<Order> readAll() {
		List<Order> orders = orderService.readAll();
		for(Order order: orders) {
			LOGGER.info(order.toString());
		}
		return orders;
	}
	/**
	 * Creates an order by taking in user input
	 * @return 
	 */

	@Override
	public Order create() {
		LOGGER.info("THIS FUNCTIONALITY HAS NOT BEEN IMPLEMENTED YET");
		return null;

	}

	/**
	 * Updates an existing ORDER by taking in user input
	 * 
	 * @return
	 */
	@Override

	public Order update() {
		LOGGER.info("THIS FUNCTIONALITY HAS NOT BEEN IMPLEMENTED YET");
		return null;

	}

	/**
	 * Deletes an existing order by the id of the customer
	 */
	
	@Override

	public void delete() {
		LOGGER.info("Please enter the id of the order you would like to delete");
		String stringId = Utils.getInput();
		long orderId = Long.parseLong(stringId);
		orderService.delete(orderId);
		LOGGER.info("Order deleted successfully");
	}

}

	
	
	