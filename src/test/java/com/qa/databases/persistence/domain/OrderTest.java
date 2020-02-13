package com.qa.databases.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.qa.databases.persistence.Order;

public class OrderTest {

	private Order order;
	private Order other;

	@Before
	public void setUp() {
		order = new Order(1L, 20L, 12D);
		other = new Order(1L, 20L, 12D);
	}

	@Test
	public void settersTest() {
		assertNotNull(order.getOrderId());
		assertNotNull(order.getFkCustomerId());
		assertNotNull(order.getCost());

		order.setOrderId(null);
		assertNull(order.getOrderId());
		order.setFkCustomerId(null);
		assertNull(order.getFkCustomerId());
		order.setCost(null);
		assertNull(order.getCost());

	}

	@Test
	public void equalsWithNull() {
		assertFalse(order.equals(null));
	}

	@Test
	public void equalsWithDifferentObject() {
		assertFalse(order.equals(new Object()));
	}

	@Test
	public void createItemWithId() {
		assertEquals(1L, order.getOrderId(), 0);
		assertEquals(20L, order.getFkCustomerId(), 0);
		assertEquals(20L, order.getCost(), 20L);
	}

	@Test
	public void checkEquality() {
		assertTrue(order.equals(order));
	}

	@Test
	public void checkEqualityBetweenDifferentObjects() {
		assertTrue(order.equals(other));
	}

	@Test
	public void fkCustomerIdNullButOtherFkCustomerIdNotNull() {
		order.setFkCustomerId(null);
		assertFalse(order.equals(other));
	}

	@Test
	public void itemFkCustomerIdsNotEqual() {
		other.setFkCustomerId(10L);
		assertFalse(order.equals(other));
	}

	@Test
	public void checkEqualityBetweenDifferentObjectsNullFkCustomerId() {
		order.setFkCustomerId(null);
		other.setFkCustomerId(null);
		assertTrue(order.equals(other));
	}

	@Test
	public void nullOrderId() {
		order.setOrderId(null);
		assertFalse(order.equals(other));
	}

	@Test
	public void nullOrderIdOnBoth() {
		order.setOrderId(null);
		other.setOrderId(null);
		assertTrue(order.equals(other));
	}

	@Test
	public void otherOrderIdDifferent() {
		other.setOrderId(2L);
		assertFalse(order.equals(other));
	}

	@Test
	public void otherCostDifferent() {
		other.setCost(30D);
		assertFalse(order.equals(other));
	}

	@Test
	public void nullCost() {
		order.setCost(null);
		assertFalse(order.equals(other));
	}

	@Test
	public void otherStockDifferent() {
		other.setCost(2D);
		assertFalse(order.equals(other));
	}

	@Test
	public void constructorWithoutOrderId() {
		Order order = new Order(20L, 12D);
		assertNull(order.getOrderId());
		assertNotNull(order.getFkCustomerId());
		assertNotNull(order.getCost());

	}

	@Test
	public void hashCodeTest() {
		assertEquals(order.hashCode(), other.hashCode());
	}

}






