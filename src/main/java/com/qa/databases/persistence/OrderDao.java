package com.qa.databases.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.databases.persistence.dao.Item;
import com.qa.databases.utils.Config;
import com.qa.databases.utils.Utils;

public class OrderDao implements Dao<Order> {
	
	private Config config = Config.getInstance();

	public static final Logger LOGGER = Logger.getLogger(ItemDao.class);
	private Statement statement = null;

	Order orderFromResultSet(ResultSet resultSet) throws SQLException {
		long id = resultSet.getLong("orders_id");
		long fkCustomerId = resultSet.getLong("fk_Customer_Id");
		double cost = resultSet.getDouble("cost");
		return new Order(id, fkCustomerId, cost);
	}

	public List<Order> readAll() {
		try (Connection connection = DriverManager.getConnection(Config.url, config.getUsername(), config.getPassword());
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from orders");){
			ArrayList<Order> orders = new ArrayList<>();
			while (resultSet.next()) {
				orders.add(orderFromResultSet(resultSet));
			}
			return orders;
		} catch (Exception e) {
			LOGGER.info("Failed to read database", e);
		}return new ArrayList<>();
	}

	@Override
	public void delete(long id) {

		try (Connection connection = DriverManager.getConnection(Config.url, config.getUsername(), config.getPassword())) {
			statement = connection.createStatement();
			statement.executeUpdate("delete from orders where id = " + id);
		} catch (Exception e) {
			LOGGER.info("Failed to delete from database", e);
		} finally {
		}

	}

	@Override
	public Order create(Order t) {
		return t;
		// TODO Auto-generated method stub

	}

	@Override
	public Order update(Order order) {
		try (Connection connection = DriverManager.getConnection(Config.getUrl(), Config.getUsername(),
				Config.getPassword()); Statement statement = connection.createStatement()) {
			Item item = order.getItemList().get(0);
			statement.executeUpdate(
					String.format("UPDATE item_order set item_quantity = '%s' WHERE order_id='%s' AND item_id = '%s';",
							item.getQuantity(), order.getId(), item.getId()));
			updateCost(order);
		} catch (Exception e) {
			Utils.errorPrint(e);
		}
		return null;
	}

	// select sum(item_quantity*value) where order_id = item_id

}
