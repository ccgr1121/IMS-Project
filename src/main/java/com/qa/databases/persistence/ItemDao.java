package com.qa.databases.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.log4j.Logger;
import com.qa.databases.DataUtil;
import com.qa.databases.utils.Config;

public class ItemDao implements Dao<Item> {

	public static final Logger logger = Logger.getLogger(ItemDao.class);
	private static Statement statement = null;
	private static ResultSet resultSet = null;
	
	
	public String readAll() {
		String result = "failed";
		try (Connection connection = DriverManager.getConnection(Config.url, 
				Config.username, Config.password)){
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from item");
			DataUtil dataUtil = new DataUtil();
			return dataUtil.resultSet_toString(resultSet);
		} catch (Exception e) {
			result = "exception fail";
			e.printStackTrace();
		}finally {
			close();
		}
		return result;
	}

	public void create(Item item) {
		try (Connection connection = DriverManager.getConnection(Config.url, 
				Config.username, Config.password)){
			Statement statement = connection.createStatement();
			statement.executeUpdate("INSERT INTO item(name, value, stock) VALUES ( \'" + item.getName() + "\', \'"
					+ item.getValue() + "\', \'" + item.getStock() + "\' );");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}

	public void update(long id, Item item) {
		try  (Connection connection = DriverManager.getConnection(Config.url, 
				Config.username, Config.password)){
			Statement statement = connection.createStatement();
			statement.executeUpdate("update item set name = '" + item.getName() + "', value = '" + item.getValue()
					+ "', stock = '" + item.getStock() + "' WHERE item_id = '" + id + "';");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}

	}

	@Override
	public void delete(long id) {

		try (Connection connection = DriverManager.getConnection(Config.url, 
				Config.username, Config.password)){
		Statement statement = connection.createStatement(); 
			statement.executeUpdate("delete from item where id = " + id);
		} catch (Exception e) {
			e.getStackTrace();
			e.getMessage();
		}finally {
			close();
		}

	}
	public void close() {
		try {
			if (statement != null)
				statement.close();
		}catch (SQLException se2) {
			se2.printStackTrace();
		}//nothing we can do
		try {	
		if (resultSet != null)
			resultSet.close();
	}catch (SQLException se) {
		se.printStackTrace();
	}

}
}