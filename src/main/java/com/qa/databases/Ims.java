package com.qa.databases;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.qa.databases.persistence.CustomerDao;
import com.qa.databases.persistence.ItemDao;
import com.qa.databases.services.CustomerServices;
import com.qa.databases.services.ItemServices;
import com.qa.databases.utils.Config;
import com.qa.databases.utils.Utils;
import com.qa.databases.domain.Domain;
import com.qa.databases.controller.Action;
import com.qa.databases.controller.CrudController;
import com.qa.databases.controller.CustomerController;
import com.qa.databases.controller.ItemController;

public class Ims {

	public static final Logger LOGGER = Logger.getLogger(Ims.class);

	public void imsSystem() throws SQLException {
		
		LOGGER.info("What is your username?");
		Config.username=Utils.getInput();
		
		LOGGER.info("What is your password?");
		Config.password=Utils.getInput();
		
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
			break;
		case STOP:
			break;
		}

	}

	public void doAction(CrudController crudController, Action action) {
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
