package com.qa.databases.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Utils {

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
			se2.printStackTrace();
		} // nothing we can do
		try {
			if (resultSet != null)
				resultSet.close();
		} catch (SQLException se) {
			se.printStackTrace();
		}

	}

}
