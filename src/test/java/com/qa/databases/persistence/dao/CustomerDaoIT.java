package com.qa.databases.persistence.dao;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.databases.domain.Customer;
import com.qa.databases.persistence.CustomerDao;
import com.qa.databases.utils.Config;

@RunWith(MockitoJUnitRunner.class)
public class CustomerDaoIT {

	@InjectMocks
	private CustomerDao dao;
	
	@Mock
	private Config config; 
	@Test
	public void testDatabaseHasValues() {
		when(config.getUsername()).thenReturn("Tsar_Charlie");
		when(config.getPassword()).thenReturn("Skippy101!");
		List<Customer> customers = dao.readAll();
		assertTrue(customers.size() > 0);
	} 
}
