package com.qa.databases.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.apache.log4j.Logger;
import com.qa.databases.DataUtil;
import com.qa.databases.utils.Config;
import com.qa.databases.utils.Utils;

public class OrderDao implements Dao<Order>{
	
	public static final Logger LOGGER = Logger.getLogger(ItemDao.class);
	private Statement statement = null;
	private ResultSet resultSet = null;

	
	public String readAll() {
		String result = "failed";
		try (Connection connection = DriverManager.getConnection(Config.url, 
				Config.username, Config.password)){
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from orders");
			DataUtil dataUtil = new DataUtil();
			return dataUtil.resultSet_toString(resultSet);
		} catch (Exception e) {
			result = "exception fail";
			LOGGER.info("Failed to read database", e);
		}finally {
			Utils.close(statement, resultSet);
		}
		return result;
	}
	
	@Override
	public void delete(long id) {

		try (Connection connection = DriverManager.getConnection(Config.url, 
				Config.username, Config.password)){
		statement = connection.createStatement(); 
			statement.executeUpdate("delete from orders where id = " + id);
		} catch (Exception e) {
			LOGGER.info("Failed to delete from database", e);
		}finally {
			Utils.close(statement, resultSet);
		}

	}

	@Override
	public void create(Order t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(long id, Order t) {
		// TODO Auto-generated method stub
		
	}
	
	//select sum(item_quantity*value) where order_id = item_id
	
	
	
	
}
