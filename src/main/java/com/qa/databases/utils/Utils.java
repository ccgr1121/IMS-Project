package com.qa.databases.utils;

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

}
