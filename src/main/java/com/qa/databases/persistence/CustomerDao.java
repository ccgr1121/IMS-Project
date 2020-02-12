package com.qa.databases.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.qa.databases.DataUtil;
import com.qa.databases.utils.Config;
import com.qa.databases.utils.Utils;

public class CustomerDao implements Dao<Customer> {
	public static final Logger LOGGER = Logger.getLogger(CustomerDao.class);
	private Statement statement = null;
	private ResultSet resultSet = null;

	public String readAll() {
		String result = "failed";
		try (Connection connection = DriverManager.getConnection(Config.url, Config.username, Config.password)) {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from customer");
			DataUtil dataUtil = new DataUtil();
			return dataUtil.resultSet_toString(resultSet);
		} catch (Exception e) {
			result = "exception fail";
			LOGGER.info("Failed to read database", e);
		} finally {
			Utils.close(statement, resultSet);
		}

		return result;
	}

	public void create(Customer customer) {
		try (Connection connection = DriverManager.getConnection(Config.url, Config.username, Config.password)) {
			statement = connection.createStatement();
			statement.executeUpdate("insert into customer(firstName, lastName) values('" + customer.getFirstName()
					+ "','" + customer.getSurname() + "')");
		} catch (Exception e) {
			LOGGER.info("Failed to create entry in database", e);

		} finally {
			Utils.close(statement, resultSet);
		}
	}

	public void update(long id, Customer customer) {
		try (Connection connection = DriverManager.getConnection(Config.url, Config.username, Config.password)) {
			statement = connection.createStatement();
			statement.executeUpdate("update customer set firstName ='" + customer.getFirstName() + "', lastName ='"
					+ customer.getSurname() + "' where customer_id =" + customer.getId());
		} catch (Exception e) {
			LOGGER.info("Failed to edit entry in database", e);
		} finally {
			Utils.close(statement, resultSet);
		}
	}

	@Override
	public void delete(long id) {
		try (Connection connection = DriverManager.getConnection(Config.url, Config.username, Config.password)) {
			statement = connection.createStatement();
			statement.executeUpdate("delete from customer where customer_id = " + id);
		} catch (Exception e) {
			LOGGER.info("Failed to delete from database", e);
		} finally {
			Utils.close(statement, resultSet);
		}
	}

}
