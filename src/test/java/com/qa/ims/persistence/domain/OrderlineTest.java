package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;


public class OrderlineTest {
	
	private Orderline orderline1;
	private Orderline orderline2;
	private Orderline orderline3;
	
	@Before
	public void setUp() {
		orderline1 = new Orderline(1L, 1L, 1L, 1);
		orderline2 = new Orderline(1L, 1L, 1L, 1);
		orderline3 = new Orderline(1L, 1L, 1L, 1, 1.00, 1L, "Frank", "Cake");
		
	}
	
	@Test
	public void settersTest() {
		assertNotNull(orderline1.getOrderlineId());
		assertNotNull(orderline1.getItemId());
		assertNotNull(orderline1.getOrderId());
		assertNotNull(orderline1.getQuantity());
		
		orderline1.setOrderlineId(null);
		assertNull(orderline1.getOrderlineId());
		orderline1.setItemId(null);
		assertNull(orderline1.getItemId());
		orderline1.setOrderId(null);
		assertNull(orderline1.getOrderId());
		orderline1.setQuantity(null);
		assertNull(orderline1.getQuantity());
		
	}
	@Test
	public void equalsWithNull() {
		assertFalse(orderline1.equals(null));
	}
	
	@Test
	public void equalsWithDifferentObject() {
		assertFalse(orderline1.equals(new Object()));
	}
	@Test
	public void createOrderlineWithId() {
		assertEquals(1L, orderline1.getOrderlineId(), 0);
		assertEquals(1L, orderline1.getItemId(), 0);
		assertEquals(1L, orderline1.getOrderId(), 0);
		assertEquals(1, orderline1.getQuantity(), 0);
	}
	@Test
	public void checkEquality() {
		assertTrue(orderline1.equals(orderline1));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjects() {
		assertTrue(orderline1.equals(orderline2));
	}
	
	@Test
	public void itemIdNullButOtherIdNotNull() {
		orderline1.setItemId(null);
		assertFalse(orderline1.equals(orderline2));
	}
	@Test
	public void itemIdNotEqual() {
		orderline2.setItemId(2L);
		assertFalse(orderline1.equals(orderline2));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjectsNullInput() {
		orderline1.setOrderId(null);
		orderline2.setOrderId(null);
		assertTrue(orderline1.equals(orderline2));
		
	}
	@Test
	public void nullOrderlineId() {
		orderline1.setOrderlineId(null);
		assertFalse(orderline1.equals(orderline2));
	}
	@Test
	public void nullOrderlineIdOnBoth() {
		orderline1.setOrderlineId(null);
		orderline2.setOrderlineId(null);
		assertTrue(orderline1.equals(orderline2));
	}
	
	@Test
	public void orderline2IdDifferent() {
		orderline2.setOrderlineId(2L);
		assertFalse(orderline1.equals(orderline2));
		
	}
	@Test
	public void nullQuantity() {
		orderline1.setQuantity(null);
		assertFalse(orderline1.equals(orderline2));
	}
	
	@Test
	public void nullQuantityForBoth() {
		orderline1.setQuantity(null);
		orderline2.setQuantity(null);
		assertTrue(orderline1.equals(orderline2));
	}
	@Test
	public void orderline2QuantityDifferent() {
		orderline2.setQuantity(3);
		assertFalse(orderline1.equals(orderline2));
	}
	@Test
	public void orderIdNullBoth() {
		orderline1.setOrderId(null);
		orderline2.setOrderId(null);
		assertTrue(orderline1.equals(orderline2));
	}
	@Test
	public void nullOrderId1() {
		orderline1.setOrderId(null);
		assertFalse(orderline1.equals(orderline2));
	}
	@Test
	public void differentOrderId() {
		orderline2.setOrderId(2L);
		assertFalse(orderline1.equals(orderline2));
	}

	@Test
	public void constructorWithoutId() {
		Orderline orderline = new Orderline(1L, 1L, 10);
		assertNull(orderline.getOrderlineId());
		assertNotNull(orderline.getItemId());
		assertNotNull(orderline.getOrderId());
		assertNotNull(orderline.getQuantity());
		
	}
	
	@Test
	
	public void hashCodeTest() {
		assertEquals(orderline1.hashCode(), orderline2.hashCode());
	}
	
	@Test
	public void hashCodeTestWithNull() {
		Orderline orderline1 = new Orderline(null, null, null, null);
		Orderline orderline2 = new Orderline(null, null, null, null);
		assertEquals(orderline1.hashCode(), orderline2.hashCode());
		
	}
	@Test
	public void toStringTest() {
		String tosString = "Orderline ID: 1, Item ID: 1, Item Name: Cake, Order ID: 1, Quantity: 1, Individual Price: 1.0, Total Price: 1.0, Customers ID: 1, First Name of Customer: Frank";
				assertEquals(tosString, orderline3.toString());
	}
}
