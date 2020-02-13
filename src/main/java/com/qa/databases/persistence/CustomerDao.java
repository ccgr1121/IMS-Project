package com.qa.databases.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import com.qa.databases.utils.Config;

public class CustomerDao implements Dao<Customer> {
	public static final Logger LOGGER = Logger.getLogger(CustomerDao.class);
	private Statement statement = null;

	private Config config = Config.getInstance();

	Customer customerFromResultSet(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong("customer_id");
		String firstName = resultSet.getString("firstName");
		String surname = resultSet.getString("lastName");
		return new Customer(id, firstName, surname);
	}
 
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
			LOGGER.info("Failed to edit entry in database", e);
		}
		return new ArrayList<>();
	}

	public Customer create(Customer customer) {
		try (Connection connection = DriverManager.getConnection(Config.url, config.getUsername(),
				config.getPassword())) {
			statement = connection.createStatement();
			statement.executeUpdate("insert into customer(firstName, lastName) values('" + customer.getFirstName()
					+ "','" + customer.getSurname() + "')");
		} catch (Exception e) {
			LOGGER.info("Failed to create entry in database", e);

		} finally {
;
		}
		return customer;
	}

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
