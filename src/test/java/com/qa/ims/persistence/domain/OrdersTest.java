package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class OrdersTest {
	
	
	private Orders order1;
	private Orders order2;
	
	@Before
	public void setUp() {
		order1 = new Orders(1L, 1L, "14/01/2021");
		order2 = new Orders(1L, 1L, "14/01/2021");
		
	}
	
	@Test
	public void settersTest() {
		assertNotNull(order1.getOrderId());
		assertNotNull(order1.getCustomerId());
		assertNotNull(order1.getDatePlaced());
		
		order1.setOrderId(null);
		assertNull(order1.getOrderId());
		order1.setCustomerId(null);
		assertNull(order1.getCustomerId());
		order1.setDatePlaced(null);
		assertNull(order1.getDatePlaced());
		
	}
	
	@Test
	public void equalsWithNull() {
		assertFalse(order1.equals(null));
	}
	
	@Test
	public void equalsWithDifferentObjects() {
		assertFalse(order1.equals(new Object()));
	}
	
	@Test
	public void createOrderWithId() {
		assertEquals(1L, order1.getOrderId(), 0);
		assertEquals(1L, order1.getCustomerId(), 0);
		assertEquals("14/01/2021", order1.getDatePlaced());
		
		
	}
	
	@Test
	public void checkEquality() {
		assertTrue(order1.equals(order1));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjects() {
		assertTrue(order1.equals(order2));
		
	}
	
	@Test
	public void customerIdNullOtherNotNull() {
		order1.setCustomerId(null);
		assertFalse(order1.equals(order2));
	}
	
	@Test
	public void customerIdNotEqual() {
		order2.setCustomerId(2L);
		assertFalse(order1.equals(order2));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjectsNullCustomerId() {
		order1.setCustomerId(null);
		order2.setCustomerId(null);
		assertTrue(order1.equals(order2));
		
	}
	@Test
	public void dateEquality() {
		order1.setDatePlaced(null);
		assertFalse(order1.equals(order2));
	}
	
	@Test
	public void nullOrderId() {
		order1.setOrderId(null);
		assertFalse(order1.equals(order2));
	}
	
	@Test
	public void orderIdBothNull() {
		order1.setOrderId(null);
		order2.setOrderId(null);
		assertTrue(order1.equals(order2));
	}
	
	@Test
	public void order2IdDifferent() {
		order2.setOrderId(2L);
		assertFalse(order1.equals(order2));
	}
	
	@Test
	public void nullDate() {
		order1.setDatePlaced(null);
		assertFalse(order2.equals(order1));
	}
	
	@Test
	public void nullDateOnBoth() {
		order1.setDatePlaced(null);
		order2.setDatePlaced(null);
		assertTrue(order1.equals(order2));
		
	}
	
	@Test
	public void order2DateDifferent() {
		order2.setDatePlaced("10/01/2021");
		assertFalse(order1.equals(order2));
	}
	
	@Test
	public void constructorWithoutId() {
		Orders order = new Orders(1L, "1/01/2021");
		assertNull(order.getOrderId());
		assertNotNull(order.getCustomerId());
		assertNotNull(order.getDatePlaced());
		
	}
	
	@Test
	public void hashCodeTest() {
		assertEquals(order1.hashCode(), order2.hashCode());
		
	}
	
	@Test
	public void hashCodeNull() {
		Orders order = new Orders(null, null, null);
		Orders order2 = new Orders(null, null, null);
		assertEquals(order.hashCode(), order2.hashCode());
				
	}
	
	@Test
	public void toStringTest() {
		String toString = "Orders [orderId=1, customerId=1, datePlaced=14/01/2021]";
		assertEquals(toString, order1.toString());
		
	}

}
