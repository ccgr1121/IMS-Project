package com.qa.databases.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.qa.databases.domain.Item;
import com.qa.databases.services.CrudServices;
import com.qa.databases.utils.Utils;

/**
 * Takes in item details for CRUD functionality
 *
 */
public class ItemController implements CrudController<Item> {

	public static final Logger LOGGER = Logger.getLogger(ItemController.class);

	private CrudServices<Item> itemService;
 
	public ItemController(CrudServices<Item> itemService) {
		this.itemService = itemService;
	}

	String getInput() {
		return Utils.getInput(); 
	}  

	/**
	 * Reads all items to the logger
	 * 
	 * @return
	 */
	@Override
	public List<Item> readAll() {
		List<Item> items = itemService.readAll();
		for (Item item : items) {
			LOGGER.info(item.toString());
		}
		return items;
	}

	/**
	 * Creates an item by taking in user input
	 * 
	 * @return
	 */

	@Override
	public Item create() {
		LOGGER.info("Please enter a name:");
		String name = getInput();
		LOGGER.info("Please enter a value:");
		String stringValue = getInput();
		Double value = Double.parseDouble(stringValue);
		LOGGER.info("Please enter the stock level:");
		String stockString = getInput();
		Integer stock = Integer.parseInt(stockString);
		Item item = itemService.create(new Item(name, value, stock));
		LOGGER.info("Item created");
		return item;
	}

	/**
	 * Updates an existing item by taking in user input
	 * 
	 * @return
	 */
	@Override
	public Item update() {
		LOGGER.info("Please enter the ID of the item you wish to edit:");
		String stringID = getInput();
		long itemId = Long.parseLong(stringID);
		LOGGER.info("What is the item's new name?");
		String name = getInput();
		LOGGER.info("What is the new value of the order?");
		String stringValue = getInput();
		double value = Double.parseDouble(stringValue);
		LOGGER.info("What is the new stock level of the item?");
		String stockString = getInput();
		int stock = Integer.parseInt(stockString);
		Item item = itemService.update(itemId, new Item(name, value, stock));
		LOGGER.info("Item has been edited successfully");
		return item;

	}
 
	/**
	 * Deletes an existing item by the id of the item.
	 */

	@Override
	public void delete() {
		LOGGER.info("Please enter the id of the item you would like to delete");
		String stringId = getInput();
		long itemId = Long.parseLong(stringId);
		itemService.delete(itemId);
		LOGGER.info("Item deleted successfully");

	}
}
