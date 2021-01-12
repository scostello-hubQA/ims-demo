package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

public class ItemsTest {
	
	private Items item;
	private Items other;
	
	@Before
	public void setUp() {
		item = new Items(1L, "Carrot cake", 2.75, 100);
		other = new Items(1L, "Carrot Cake", 2.75, 100);
		
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
	
	
	

}
