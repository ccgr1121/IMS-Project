package com.qa.databases.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.databases.domain.Customer;
import com.qa.databases.utils.Config;

public class CustomerDao implements Dao<Customer> {
	public static final Logger LOGGER = Logger.getLogger(CustomerDao.class);
	private Statement statement = null;
	Config config = new Config();

	Customer customerFromResultSet(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong("customer_id");
		String firstName = resultSet.getString("firstName");
		String surname = resultSet.getString("lastName");
		return new Customer(id, firstName, surname);
	}

	/**
	 *  This method allows for all customers in the database to be read.
	 *  
	 *  @Author Charlie Reddin
	 */
	
	@Override
	public List<Customer> readAll() {
		try (Connection connection = DriverManager.getConnection(Config.url, config.getUsername(),
				config.getPassword());
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select * from customer");) {
			ArrayList<Customer> customers = new ArrayList<>();
			while (resultSet.next()) {
				customers.add(customerFromResultSet(resultSet));
			}
			return customers;
		} catch (SQLException e) {
			LOGGER.error("Failed to read database", e);
			return new ArrayList<>();
		}
		
	}

	/**
	 *  This method allows for customers in the database to be created.
	 *  
	 *  @Author Charlie Reddin
	 */
	
	public Customer create(Customer customer) {
		try (Connection connection = DriverManager.getConnection(Config.url, config.getUsername(),
				config.getPassword())) {
			statement = connection.createStatement();
			statement.executeUpdate("insert into customer(firstName, lastName) values('" + customer.getFirstName()
					+ "','" + customer.getSurname() + "')");
		} catch (Exception e) {
			LOGGER.info("Failed to create entry in database", e);

		} finally {

		}
		return customer;
	}

	/**
	 *  This method allows for customers in the database to be edited.
	 *  
	 *  @Author Charlie Reddin
	 */
	
	public Customer update(long id, Customer customer) {
		try (Connection connection = DriverManager.getConnection(Config.url, config.getUsername(),
				config.getPassword())) {
			statement = connection.createStatement();
			statement.executeUpdate("update customer set firstName ='" + customer.getFirstName() + "', lastName ='"
					+ customer.getSurname() + "' where customer_id =" + customer.getId());
		} catch (Exception e) {
			LOGGER.info("Failed to edit entry in database", e);
		} finally {

		}
		return customer;
	}

	/**
	 *  This method allows for customers in the database to be deleted.
	 *  
	 *  @Author Charlie Reddin
	 */
	
	@Override
	public void delete(long id) {
		try (Connection connection = DriverManager.getConnection(Config.url, config.getUsername(),
				config.getPassword())) {
			statement = connection.createStatement();
			statement.executeUpdate("delete from customer where customer_id = " + id);
		} catch (Exception e) {
			LOGGER.info("Failed to delete from database", e);
		} finally {

		}
	}

}
