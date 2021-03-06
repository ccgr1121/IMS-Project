package com.qa.databases.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.databases.domain.Item;
import com.qa.databases.utils.Config;

public class ItemDao implements Dao<Item> {
	public static final Logger LOGGER = Logger.getLogger(ItemDao.class);
	private Statement statement = null;
	Config config = new Config();
 
	Item itemFromResultSet(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong("item_id");
		String name = resultSet.getString("name");
		Double value = resultSet.getDouble("value");
		Integer stock = resultSet.getInt("stock");
		return new Item(id, name, value, stock); 
	}
 
	/**
	 *  This method allows for all items in the database to be read.
	 *  
	 *  @Author Charlie Reddin
	 */
	
	public List<Item> readAll() {
		try (Connection connection = DriverManager.getConnection(Config.url, config.getUsername(),
				config.getPassword());
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from item");){
			ArrayList<Item> items = new ArrayList<>();
			while (resultSet.next()) {
				items.add(itemFromResultSet(resultSet));
			}
			return items;
		} catch (SQLException e) {
			LOGGER.error("Failed to read database", e);
		}
		return new ArrayList<>();
	}

	/**
	 *  This method allows for items in the database to be created.
	 *  
	 *  @Author Charlie Reddin
	 */
	
	public Item create(Item item) {
		try (Connection connection = DriverManager.getConnection(Config.url, config.getUsername(),
				config.getPassword())) {
			statement = connection.createStatement();
			statement.executeUpdate("INSERT INTO item(name, value, stock) VALUES ( \'" + item.getName() + "\', \'"
					+ item.getValue() + "\', \'" + item.getStock() + "\' );");
		} catch (Exception e) {
			LOGGER.info("Failed to create entry in database", e);
		} finally {
		}
		return item;
	}

	/**
	 *  This method allows for items in the database to be edited.
	 *  
	 *  @Author Charlie Reddin
	 */
	
	
	public Item update(long id, Item item) {
		try (Connection connection = DriverManager.getConnection(Config.url, config.getUsername(),
				config.getPassword())) {
			statement = connection.createStatement();
			statement.executeUpdate("update item set name = '" + item.getName() + "', value = '" + item.getValue()
					+ "', stock = '" + item.getStock() + "' WHERE item_id = '" + id + "';");
		} catch (Exception e) {
			LOGGER.info("Failed to edit entry in database", e);
		} finally {
		}
		return item;
 
	}

	/**
	 *  This method allows for items in the database to be deleted.
	 *  
	 *  @Author Charlie Reddin
	 */
	@Override
	public void delete(long id) {

		try (Connection connection = DriverManager.getConnection(Config.url, config.getUsername(),
				config.getPassword())) {
			statement = connection.createStatement();
			statement.executeUpdate("delete from item where item_id = " + id);
		} catch (Exception e) {
			LOGGER.info("Failed to delete from database", e);
		} finally {
		}

	}
}