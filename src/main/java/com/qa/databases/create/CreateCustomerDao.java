package com.qa.databases.create;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.qa.databases.create.CreateCustomer;

public class CreateCustomerDao {

	private Connection connection;
	Scanner scanner = new Scanner(System.in);

	public CreateCustomerDao() throws SQLException {

		this.connection = DriverManager.getConnection("jdbc:mysql://34.89.101.76:3306/IMS", "Tsar_Charlie", "Skippy101!");
	}
	
	
	public String userInput(String output) {
		String input = null;
		System.out.println(output);
		return input = scanner.nextLine();

	}
	
	
	public List<CreateCustomer> create() {
		CreateCustomer customer = null;
		String stringFirstName = userInput("What is your first name?");
		String stringLastName = userInput("What is your last name?");
		ArrayList<CreateCustomer> createcustomers = new ArrayList<CreateCustomer>();
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate("INSERT INTO customer(firstName, lastName) VALUES (" + stringFirstName + ", " + stringLastName + ");");

				//			while (resultSet.next()) {
//				Long customer_id = resultSet.getLong("customer_id");
//				String firstName = resultSet.getString("firstName");
//				String lastName = resultSet.getString("lastName");
//				CreateCustomer customer = new CreateCustomer(customer_id, firstName, lastName);
				createcustomers.add(customer);
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return createcustomers;
	}
}
