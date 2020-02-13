package com.qa.databases.utils;

public class Config {
	/**
	 * @author Charlie
	 */
	private static String username = "Tsar_Charlie";
	


	private static String password = "Skippy101!";
	public static String url = "jdbc:mysql://34.89.101.76:3306/IMS";

	private Config() {

	}

	public static String getUsername() {
		return username;
	}
	
	public static String getPassword() {
		return password;
	}
	public static void setUsername(String username) {
		Config.username = username;
	}

	public static void setPassword(String password) {
		Config.password = password;
		
	}

}