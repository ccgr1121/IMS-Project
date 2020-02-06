package com.qa.databases.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ViewCustomerDao {

	private Connection connection;

	public ViewCustomerDao() throws SQLException {

		this.connection = DriverManager.getConnection("jdbc:mysql://34.89.101.76:3306/IMS", "Tsar_Charlie", "Skippy101!");
	}


	public List<ViewCustomer> readAll() {
		ArrayList<ViewCustomer> customers = new ArrayList<ViewCustomer>();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from customer");
			while (resultSet.next()) {
				Long customer_id = resultSet.getLong("customer_id");
				String firstName = resultSet.getString("firstName");
				String lastName = resultSet.getString("lastName");
				ViewCustomer customer = new ViewCustomer(customer_id, firstName, lastName);
				customers.add(customer);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customers;
	}
}
