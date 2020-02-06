package com.qa.databases.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ItemDao {

	private Connection connection;

	public ItemDao() throws SQLException {

		this.connection = DriverManager.getConnection("jdbc:mysql://34.89.101.76:3306/IMS", "Tsar_Charlie", "Skippy101!");
	}


	public List<Item> readAll() {
		ArrayList<Item> items = new ArrayList<Item>();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from item");
			while (resultSet.next()) {
				Long item_id = resultSet.getLong("item_id");
				String name = resultSet.getString("name");
				Long value = resultSet.getLong("value");
				int stock = resultSet.getInt("stock");
				Item item = new Item(item_id, name, value, stock);
				items.add(item);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return items;
	}
}
