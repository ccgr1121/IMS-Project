package com.qa.databases.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.apache.log4j.Logger;
import com.qa.databases.DataUtil;
import com.qa.databases.utils.Config;
import com.qa.databases.utils.Utils;

public class ItemDao implements Dao<Item> {

	public static final Logger LOGGER = Logger.getLogger(ItemDao.class);
	private Statement statement = null;
	private ResultSet resultSet = null;
	
	
	public String readAll() {
		String result = "failed";
		try (Connection connection = DriverManager.getConnection(Config.url, 
				Config.username, Config.password)){
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from item");
			DataUtil dataUtil = new DataUtil();
			return dataUtil.resultSet_toString(resultSet);
		} catch (Exception e) {
			result = "exception fail";
			LOGGER.info("Failed to read database", e);
		}finally {
			Utils.close(statement, resultSet);
		}
		return result;
	}


	public void create(Item item) {
		try (Connection connection = DriverManager.getConnection(Config.url, 
				Config.username, Config.password)){
			statement = connection.createStatement();
			statement.executeUpdate("INSERT INTO item(name, value, stock) VALUES ( \'" + item.getName() + "\', \'"
					+ item.getValue() + "\', \'" + item.getStock() + "\' );");
		} catch (Exception e) {
			LOGGER.info("Failed to create entry in database", e);
		}finally {
			Utils.close(statement, resultSet);
		}
	}

	public void update(long id, Item item) {
		try  (Connection connection = DriverManager.getConnection(Config.url, 
				Config.username, Config.password)){
			statement = connection.createStatement();
			statement.executeUpdate("update item set name = '" + item.getName() + "', value = '" + item.getValue()
					+ "', stock = '" + item.getStock() + "' WHERE item_id = '" + id + "';");
		} catch (Exception e) {
			LOGGER.info("Failed to edit entry in database", e);
		}finally {
			Utils.close(statement, resultSet);
		}

	}

	@Override
	public void delete(long id) {

		try (Connection connection = DriverManager.getConnection(Config.url, 
				Config.username, Config.password)){
		statement = connection.createStatement(); 
			statement.executeUpdate("delete from item where item_id = " + id);
		} catch (Exception e) {
			LOGGER.info("Failed to delete from database", e);
		}finally {
			Utils.close(statement, resultSet);
		}

	}
}