package com.qa.databases.view;

import java.sql.SQLException;
import java.util.List;

public class Runner {
	public static void main(String[] args) throws SQLException {
		ViewCustomerDao vcdao = new ViewCustomerDao();
		vcdao.toString();
		List<ViewCustomer> customers = vcdao.readAll();
		for(ViewCustomer customer : customers) {
			System.out.println(customer.getId() + " " + customer.getFirstName());
		}
		ViewItemDao idao = new ViewItemDao();
		idao.toString();
		List<ViewItem> items = idao.readAll();
		for (ViewItem item : items) {
			System.out.println(item.getId() + " " + item.getName());
		}
		
		OrdersDao odao = new OrdersDao();
		odao.toString();
		List<Orders> orders= odao.readAll();
		for (Orders orders1 : orders) {
			System.out.println(orders1.getId() + " " + orders1.getQuantity());
		}
	}
}
