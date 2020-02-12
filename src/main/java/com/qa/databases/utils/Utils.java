package com.qa.databases.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.qa.databases.persistence.ItemDao;

public class Utils {
	public static final Logger LOGGER = Logger.getLogger(ItemDao.class);
	public static String getInput() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	public static void close(Statement statement, ResultSet resultSet) {
		try {
			if (statement != null)
				statement.close();
		} catch (SQLException se2) {
			LOGGER.error("", se2);
		} // nothing we can do
		try {
			if (resultSet != null)
				resultSet.close();
		} catch (SQLException se) {
			LOGGER.error("", se);
		}

	}

}
