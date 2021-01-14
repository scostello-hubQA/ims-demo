package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ItemsTest {

	private Items item;
	private Items other;

	@Before
	public void setUp() {
		item = new Items(1L, "Carrot cake", 2.75, 100);
		other = new Items(1L, "Carrot cake", 2.75, 100);

	}

	@Test
	public void settersTest() {
		assertNotNull(item.getItem_id());
		assertNotNull(item.getItemName());
		assertNotNull(item.getPrice());
		assertNotNull(item.getStock());

		item.setItem_id(null);
		assertNull(item.getItem_id());
		item.setItemName(null);
		assertNull(item.getItemName());
		item.setPrice(null);
		assertNull(item.getPrice());
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
		assertEquals(1L, item.getItem_id(), 0);
		assertEquals("Carrot cake", item.getItemName());
		assertEquals(2.75, item.getPrice(), 0.01);
		assertEquals(100, item.getStock(), 0);
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
		item.setItemName(null);
		assertFalse(item.equals(other));
	}

	@Test
	public void itemNamesNotEqual() {
		other.setItemName("Chocolate");
		assertFalse(item.equals(other));
	}

	@Test
	public void checkEqualityBetweenDifferentObjectsNullName() {
		item.setItemName(null);
		other.setItemName(null);
		assertTrue(item.equals(other));

	}

	@Test
	public void nullId() {
		item.setItem_id(null);
		assertFalse(item.equals(other));
	}

	@Test
	public void nulldOnBoth() {
		item.setItem_id(null);
		other.setItem_id(null);
		assertTrue(item.equals(other));

	}

	@Test
	public void otherIdDifferent() {
		other.setItem_id(2L);
		assertFalse(item.equals(other));

	}

	@Test
	public void nullPrice() {
		item.setPrice(0.0);
		assertFalse(other.equals(item));
	}

	@Test
	public void nullPriceOnBoth() {
		item.setPrice(0.0);
		other.setPrice(0.0);
		assertTrue(item.equals(other));

	}

	@Test
	public void otherPriceDifferent() {
		other.setPrice(50.00);
		assertFalse(item.equals(other));

	}

	@Test
	public void nullStock() {
		item.setStock(null);
		assertFalse(item.equals(other));

	}

	@Test
	public void nullStockOnBoth() {
		item.setStock(null);
		other.setStock(null);
		assertTrue(item.equals(other));

	}

	@Test
	public void otherStockDifferent() {
		other.setStock(50);
		assertFalse(item.equals(other));

	}
	
	@Test
	public void constructorWithoutId() {
		Items item = new Items("sponge", 4.99, 10);
		assertNull(item.getItem_id());
		assertNotNull(item.getItemName());
		assertNotNull(item.getPrice());
		assertNotNull(item.getStock());
	}
	
	@Test
	public void hashCodeTest() {
		assertEquals(item.hashCode(), other.hashCode());
		
	}
	
	@Test
	public void hashCodeTestWithNull() {
		Items item = new Items(0L, null, 0.0, 0);
		Items other = new Items(0L, null, 0.0, 0);
		assertEquals(item.hashCode(), other.hashCode());
	}
	
	@Test
	public void toStringTest() {
		String toString = "Item Id: 1, Item Name: Carrot cake, price: 2.75, stock: 100";
		assertEquals(toString, item.toString());
	}
}
