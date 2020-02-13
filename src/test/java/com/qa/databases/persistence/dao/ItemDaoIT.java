package com.qa.databases.persistence.dao;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.databases.persistence.Item;
import com.qa.databases.persistence.ItemDao;
import com.qa.databases.utils.Config;

@RunWith(MockitoJUnitRunner.class)
public class ItemDaoIT {  

	@InjectMocks
	private ItemDao dao;

	@Mock
	private Config config;
	@Test
	public void testDatabaseHasValues() {
		when(config.getUsername()).thenReturn("Tsar_Charlie");
		when(config.getPassword()).thenReturn("Skippy101!");
		List<Item> items = dao.readAll();
		assertTrue(items.size() > 0); 
	}
  
}
