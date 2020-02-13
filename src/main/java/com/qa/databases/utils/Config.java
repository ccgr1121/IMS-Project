package com.qa.databases.utils;

public class Config {

	public static String username;
	public static String password;
	public static final String url = "jdbc:mysql://34.89.101.76:3306/IMS";

	
	private Config() {
	}

	public String getUsername() {
		return username == null ? username : Utils.getInput();
	}

	public String getPassword() {
		return password == null ? password : Utils.getInput();
	}

}
