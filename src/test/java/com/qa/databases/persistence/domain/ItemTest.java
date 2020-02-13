package com.qa.databases.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.qa.databases.persistence.Item;

public class ItemTest {

	private Item item;
	private Item other;

	@Before
	public void setUp() {
		item = new Item(1L, "apple", 20, 12);
		other = new Item(1L, "apple", 20, 12);
	}

	@Test
	public void settersTest() {
		assertNotNull(item.getItemId());
		assertNotNull(item.getName());
		assertNotNull(item.getValue());
		assertNotNull(item.getStock());

		item.setItemId(null);
		assertNull(item.getItemId());
		item.setName(null);
		assertNull(item.getName());
		item.setValue(null);
		assertNull(item.getValue());
		item.setStock(null);
		assertNull(item.getStock());

	}

	@Test
	public void equalsWithNull() {
		assertFalse(item.equals(null));
	}

	@Test
	public void equalsWithDifferentObject() {
		assertFalse(item.equals(new Object()));
	}

	@Test
	public void createItemWithId() {
		assertEquals(1L, item.getItemId(), 0);
		assertEquals("apple", item.getName());
		assertEquals(20D, item.getValue());
		assertEquals(12, item.getStock());
	}

	@Test
	public void checkEquality() {
		assertTrue(item.equals(item));
	}

	@Test
	public void checkEqualityBetweenDifferentObjects() {
		assertTrue(item.equals(other));
	}

	@Test
	public void itemNameNullButOtherNameNotNull() {
		item.setName(null);
		assertFalse(item.equals(other));
	}

	@Test
	public void customerNamesNotEqual() {
		other.setName("banana");
		assertFalse(item.equals(other));
	}

	@Test
	public void checkEqualityBetweenDifferentObjectsNullName() {
		item.setName(null);
		other.setName(null);
		assertTrue(item.equals(other));
	}

	@Test
	public void nullId() {
		item.setItemId(null);
		assertFalse(item.equals(other));
	}

	@Test
	public void nullIdOnBoth() {
		item.setItemId(null);
		other.setItemId(null);
		assertTrue(item.equals(other));
	}

	@Test
	public void otherIdDifferent() {
		other.setItemId(2L);
		assertFalse(item.equals(other));
	}

	@Test
	public void nullValue() {
		item.setValue(null);
		assertFalse(item.equals(other));
	}

	@Test
	public void nullValueOnBoth() {
		item.setValue(null);
		other.setValue(null);
		assertTrue(item.equals(other));
	}

	@Test
	public void otherSurnameDifferent() {
		other.setValue(30D);
		assertFalse(item.equals(other));
	}

	@Test
	public void constructorWithoutItemId() {
		Item item = new Item("apple", 21D, 12);
		assertNull(item.getItemId());
		assertNotNull(item.getName());
		assertNotNull(item.getValue());
		assertNotNull(item.getStock());
	}

	@Test
	public void hashCodeTest() {
		assertEquals(item.hashCode(), other.hashCode());
	}

	@Test
	public void hashCodeTestWithNull() {
		Item item = new Item("null", null, null);
		Item other = new Item("null", null, null);
		assertEquals(item.hashCode(), other.hashCode());
	}

	@Test
	public void toStringTest() {
		String toString = "id:1 first name:Chris surname:Perrins";
		assertEquals(toString, item.toString());
	}
}
