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
import com.qa.databases.utils.Utils;

public class OrderDao implements Dao<Order> {

	public static final Logger LOGGER = Logger.getLogger(ItemDao.class);
	private Statement statement = null;
	private ResultSet resultSet = null;
	private Config config = Config.getInstance();


	Order orderFromResultSet(ResultSet resultSet) throws SQLException {
		long id = resultSet.getLong("id");
		long fkCustomerId = resultSet.getLong("fkCustomerId");
		long fkItemId = resultSet.getLong("fkItemId");
		int quantity = resultSet.getInt("quantity");
		double value = resultSet.getDouble("value");
		return new Order(id, fkCustomerId, fkItemId, quantity, value);
	}

	public List<Order> readAll() { 
		String result = "failed";
		try (Connection connection = DriverManager.getConnection(Config.url, config.getUsername(), config.getPassword())) {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from orders");
			ArrayList<Order> orders = new ArrayList<>();
			while (resultSet.next()) {
				orders.add(orderFromResultSet(resultSet));
//			DataUtil dataUtil = new DataUtil();
//			return dataUtil.resultSet_toString(resultSet);
			}
		} catch (Exception e) {
			result = "exception fail";
			LOGGER.info("Failed to read database", e);
		} finally {
			Utils.close(statement, resultSet);
		}
		return new ArrayList<>();
	}

	@Override
	public void delete(long id) {

		try (Connection connection = DriverManager.getConnection(Config.url, config.getUsername(), config.getPassword())) {
			statement = connection.createStatement();
			statement.executeUpdate("delete from orders where id = " + id);
		} catch (Exception e) {
			LOGGER.info("Failed to delete from database", e);
		} finally {
			Utils.close(statement, resultSet);
		}

	}

	@Override
	public Order create(Order t) {
		return t;
		// TODO Auto-generated method stub

	}

	@Override
	public Order update(long id, Order t) {
		return t;
		// TODO Auto-generated method stub

	}

	// select sum(item_quantity*value) where order_id = item_id

}
