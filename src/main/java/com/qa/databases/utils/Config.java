package com.qa.databases.utils;

public class Config {

	private String username;
	private String password;
	public static final String url = "jdbc:mysql://34.89.101.76:3306/IMS";

	private static Config instance;

	public static final Config getInstance() {
		if (instance == null) {
			instance = new Config();
		}
		return instance;
	} 
	
	
	private Config() {
	}

	public String getUsername() {
		return username == null ? username : Utils.getInput();
	}

	public String getPassword() {
		return password == null ? password : Utils.getInput();
	}

}
