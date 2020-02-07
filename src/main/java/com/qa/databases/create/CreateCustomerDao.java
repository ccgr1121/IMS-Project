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

		this.connection = DriverManager.getConnection("jdbc:mysql://34.89.101.76:3306/IMS", "Tsar_Charlie",
				"Skippy101!");
	}

	public String userInput(String output) {
		System.out.println(output);
		return scanner.nextLine();

	}

	public CreateCustomer create() {
		String stringFirstName = userInput("What is your first name?");
		String stringLastName = userInput("What is your last name?");
		CreateCustomer customer = new CreateCustomer(1L, stringFirstName, stringLastName);
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate("INSERT INTO customer(firstName, lastName) VALUES ( \'" + stringFirstName + "\', \'"
					+ stringLastName + "\');");

			return customer;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return customer;
	}
}
