package com.qa.databases.utils;

public class Config {

	private static String username = Utils.getInput();
	private static String password = Utils.getInput();
	public static final String url = "jdbc:mysql://34.89.101.76:3306/IMS";

	public static String getUsername() {
		return username = Config.getUsername();
	}

	public static String getPassword() {
		return password = Config.getPassword();
	}

	public static void setUsername(String username) {
		Config.username = Utils.getInput();
	}

	public static void setPassword(String password) {
		Config.password = Utils.getInput();
	}

}
