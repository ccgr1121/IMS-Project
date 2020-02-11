
package com.qa.databases;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.qa.databases.Ims;

public class Runner { 

	public static final Logger LOGGER = Logger.getLogger(Runner.class);

	public static void main(String[] args) throws SQLException {
		Ims ims = new Ims();
		ims.imsSystem();
	}
 
}