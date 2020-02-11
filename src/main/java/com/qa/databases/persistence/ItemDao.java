package com.qa.databases.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.apache.log4j.Logger;
import com.qa.databases.DataUtil;
import com.qa.databases.controller.ItemController;
import com.qa.databases.utils.Config;

public class ItemDao implements Dao<Item> {

	public static final Logger logger = Logger.getLogger(ItemDao.class);

	Connection connection = DriverManager.getConnection("jdbc:mysql://34.89.101.76:3306/IMS", Config.username,
			Config.password);
	
	public String readAll() {
		String result = "failed";
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from item");
			DataUtil dataUtil = new DataUtil();
			return dataUtil.resultSet_toString(resultSet);
		} catch (Exception e) {
			result = "exception fail";
			e.printStackTrace();
		}
		return result;
	}

	public void create(Item item) {
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate("INSERT INTO item(name, value, stock) VALUES ( \'" + item.getName() + "\', \'"
					+ item.getValue() + "\', \'" + item.getStock() + "\' );");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(long id, Item item) {
		try  {
			Statement statement = connection.createStatement();
			statement.executeUpdate("update item set name = '" + item.getName() + "', value = '" + item.getValue()
					+ "', stock = '" + item.getStock() + "' WHERE item_id = '" + id + "';");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(long id) {

		try {
		Statement statement = connection.createStatement(); 
			statement.executeUpdate("delete from item where id = " + id);
		} catch (Exception e) {
			e.getStackTrace();
			e.getMessage();
		}

	}


}
