package com.qa.databases.utils;

public class Config {
	/**
	 * The Config file contains the username and password methods, which allow for their access from the rest of the program.
	 * 
	 * @author Charlie
	 */
	private String username;

	private String password;
	public static final String url = "jdbc:mysql://34.89.101.76:3306/IMS";

	public Config() {

	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;

	}

}