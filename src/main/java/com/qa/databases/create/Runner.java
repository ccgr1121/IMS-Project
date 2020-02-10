package com.qa.databases.create;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qa.databases.view.ViewCustomer;
import com.qa.databases.view.ViewCustomerDao;

public class Runner {

	public static void main(String[] args) throws SQLException {

		CreateCustomerDao ccdao = new CreateCustomerDao();
		CreateCustomer customer = ccdao.create();
		System.out.println(customer.getFirstName() + " " + customer.getLastName() + " has been added to the database");

//		CreateItemDao cidao = new CreateItemDao();
//		CreateItem item = cidao.create();
//		System.out.println(item.getStock() + " number of " + item.getName() + " have been added to the database");
	}

}
