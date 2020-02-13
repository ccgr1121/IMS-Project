package com.qa.databases;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.qa.databases.controller.Action;
import com.qa.databases.controller.CrudController;
import com.qa.databases.controller.CustomerController;
import com.qa.databases.controller.ItemController;
import com.qa.databases.controller.OrderController;
import com.qa.databases.domain.Domain;
import com.qa.databases.persistence.CustomerDao;
import com.qa.databases.persistence.ItemDao;
import com.qa.databases.persistence.OrderDao;
import com.qa.databases.services.CustomerServices;
import com.qa.databases.services.ItemServices;
import com.qa.databases.services.OrderServices;
import com.qa.databases.utils.Config;
import com.qa.databases.utils.Utils;

public class Ims {

	public static final Logger LOGGER = Logger.getLogger(Ims.class);

	Config config = new Config();

	public void imsSystem() {
		LOGGER.info("What is your username");
		config.setUsername(Utils.getInput());
		LOGGER.info("What is your password");
		config.setPassword(Utils.getInput());
		boolean exit = true;
		while (exit) {

			LOGGER.info("Which entity would you like to use?");
			Domain.printDomains();

			Domain domain = Domain.getDomain();
			LOGGER.info("What would you like to do with " + domain.name().toLowerCase() + ":");

			Action.printActions();
			Action action = Action.getAction();

			switch (domain) {
			case CUSTOMER:
				CustomerController customerController = new CustomerController(new CustomerServices(new CustomerDao()));
				doAction(customerController, action);
				break;
			case ITEM:
				ItemController itemController = new ItemController(new ItemServices(new ItemDao()));
				doAction(itemController, action);
				break;
			case ORDER:
				OrderController orderController = new OrderController(new OrderServices(new OrderDao()));
				doAction(orderController, action);
				break;
			case STOP:
				break;
			}
		}

	}

	public void doAction(CrudController<?> crudController, Action action) {
		switch (action) {
		case CREATE:
			crudController.create();
			break;
		case READ:
			crudController.readAll();
			break;
		case UPDATE:
			crudController.update();
			break;
		case DELETE:
			crudController.delete();
			break;
		case RETURN:
			break;
		default:
			break;
		}
	}
}
