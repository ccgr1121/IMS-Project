package com.qa.databases.controller;

import org.apache.log4j.Logger;

import com.qa.databases.persistence.Item;
import com.qa.databases.services.CrudServices;
import com.qa.databases.utils.Utils;

public class ItemController implements CrudController {

	public static final Logger LOGGER = Logger.getLogger(ItemController.class);

	private CrudServices<Item> itemService;

	public ItemController(CrudServices<Item> itemService) {
		this.itemService = itemService;
	}

	public void readAll() {
		itemService.readAll();
		LOGGER.info("Current list of Items");
		System.out.println(itemService.readAll());
	}

	public void create() {
		LOGGER.info("Please enter a name:");
		String name = Utils.getInput();
		LOGGER.info("Please enter a value:");
		String stringValue = Utils.getInput();
		Double value = Double.parseDouble(stringValue);
		LOGGER.info("Please enter the stock level:");
		String stockString = Utils.getInput();
		int stock = Integer.parseInt(stockString);
		itemService.create(new Item(name, value, stock));
		LOGGER.info("Item created");
	}

	public void update() {
		LOGGER.info("Please enter the ID of the item you wish to edit:");
		String stringID = Utils.getInput();
		long itemId = Long.parseLong(stringID);
		LOGGER.info("What is the item's new name?");
		String name = Utils.getInput();
		LOGGER.info("What is the new value of the order?");
		String stringValue = Utils.getInput();
		double value = Double.parseDouble(stringValue);
		LOGGER.info("What is the new stock level of the item?");
		String stockString = Utils.getInput();
		int stock = Integer.parseInt(stockString);
		itemService.update(itemId, new Item(name, value, stock));
		LOGGER.info("Item has been edited successfully");

	}

	public void delete() {

	}

}