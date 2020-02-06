package com.qa.databases.create;

public class CreateCustomer {

	private Long customer_id;
	private String firstName;
	private String lastName;

	public CreateCustomer(Long customer_id, String firstName, String lastName) {
		this.customer_id = customer_id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Long getId() {
		return customer_id;
	} 

	public void setId(Long id) {
		this.customer_id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
