//package com.qa.databases.create;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//import com.qa.databases.create.CreateItem;
//
//public class CreateItemDao {
//
//	private Connection connection;
//	Scanner scanner = new Scanner(System.in);
//
//	public CreateItemDao() throws SQLException {
//
//		this.connection = DriverManager.getConnection("jdbc:mysql://34.89.101.76:3306/IMS", "Tsar_Charlie",
//				"Skippy101!");
//	}
//
//	public String userInput(String output) {
//		System.out.println(output);
//		return scanner.nextLine();
//	}	
//
//
//	public CreateItem create() {
//		String stringName = userInput("What is the name of the item?");
//		double doubleValue = userInput("What is your last name?");
//		int intStock = userInput("How many of the items are you adding?");
//		CreateItem item = new CreateItem(1L, stringName, doubleValue, intStock);
//		try {
//			Statement statement = connection.createStatement();
//			statement.executeUpdate("INSERT INTO customer(firstName, lastName) VALUES ( \'" + stringName + "\', \'"
//					//+ doubleValue + "\', \'" + intStock + "\' );");
//
//			return item;
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return item;
//	}
//}
