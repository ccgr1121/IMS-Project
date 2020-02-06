package com.qa.databases.create;

import java.sql.SQLException;
import java.util.List;

import com.qa.databases.view.ViewCustomer;
import com.qa.databases.view.ViewCustomerDao;

public class Runner {
	
	public static void main(String[] args) throws SQLException {
		
		CreateCustomerDao ccdao = new CreateCustomerDao();
		ccdao.toString();
		List<CreateCustomer> customers = ccdao.create();
		for(CreateCustomer customer : customers) {
			System.out.println(customer.getFirstName() + " " + customer.getLastName() + " has been added to the database");
		}
		
	}

}
