package com.qa.databases.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.qa.databases.DataUtil;
import com.qa.databases.controller.CustomerController;
import com.qa.databases.persistence.Customer;
import com.qa.databases.utils.Config;

public class CustomerDao implements Dao<Customer> {

	public static final Logger logger = Logger.getLogger(CustomerController.class);

	public String readAll() {
		String result = "failed";
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://34.89.101.76:3306/IMS", Config.username,
				Config.password)) {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from customer");
			DataUtil dataUtil = new DataUtil();
			return dataUtil.resultSet_toString(resultSet);
		} catch (Exception e) {
			result = "exception fail";
			e.printStackTrace();
		}
		return result;
	}

	public void create(Customer customer) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://34.89.101.76:3306/IMS", Config.username,
				Config.password)) {
			Statement statement = connection.createStatement();
			statement.executeUpdate("insert into customer(firstName, lastName) values('" + customer.getFirstName()
					+ "','" + customer.getSurname() + "')");
		} catch (Exception e) {

		}
	}

	public void update(long id, Customer customer) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://34.89.101.76:3306/IMS", Config.username,
				Config.password)) {
			Statement statement = connection.createStatement();
			statement.executeUpdate("update customers set firstName ='" + customer.getFirstName() + "', lastName ='"
					+ customer.getSurname() + "' where customer_id =" + customer.getId());
		} catch (Exception e) {

		}

	}

	public void delete(Customer customer) {

	}

}
