package com.qa.databases.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrdersDao {

	private Connection connection;
	
	public OrdersDao() throws SQLException {
		this.connection = DriverManager.getConnection("jdbc:mysql://34.89.101.76:3306/IMS", "Tsar_Charlie", "Skippy101!");
	}

	public List<Orders> readAll(){
		ArrayList<Orders> orders = new ArrayList<Orders>();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from orders");
			while (resultSet.next()) {
				Long orders_id = resultSet.getLong("orders_id");
				Long fk_customer_id = resultSet.getLong("fk_customer_id");
				Long fk_item_id = resultSet.getLong("fk_item_id");
				Long quantity = resultSet.getLong("quantity");
				Long cost = resultSet.getLong("cost");
				Orders order = new Orders(orders_id, fk_customer_id, fk_item_id, quantity, cost);
				orders.add(order);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orders;
	}
	
}
