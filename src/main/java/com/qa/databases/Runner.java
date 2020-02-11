//package com.qa.databases;
//
//import java.sql.SQLException;
//import java.util.List;
//
//import com.qa.databases.view.ViewOrdersDao;
//
//public class Runner {
//	public static void main(String[] args) throws SQLException {
//		

//		ViewCustomerDao vcdao = new ViewCustomerDao();
//		System.out.println(vcdao.readAll());

//		ViewItemDao vidao = new ViewItemDao();
//		System.out.println(vidao.readAll());		

//		ViewOrdersDao vodao = new ViewOrdersDao();
//		System.out.println(vodao.readAll());
//		
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