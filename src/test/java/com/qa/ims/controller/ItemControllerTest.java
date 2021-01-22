package com.qa.ims.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.persistence.domain.Items;
import com.qa.ims.services.ItemServices;

@RunWith(MockitoJUnitRunner.class)
public class ItemControllerTest {
	
	@Mock
	private ItemServices itemServices;
	
	@Spy
	@InjectMocks
	private ItemController itemController;
	
	@Test
	public void readAllTest() {
		ItemController itemController = new ItemController(itemServices);
		List<Items> items = new ArrayList<>();
		items.add(new Items("carrot cake", 5.00, 25));
		items.add(new Items("chocolate cake", 6.00, 50));
		items.add(new Items("jaffa cake", 2.00, 100));
		Mockito.when(itemServices.readAll()).thenReturn(items);
		assertEquals(items, itemController.readAll());
		
	}
	
	@Test
	public void createTest() {
		String itemName = "carrot cake";
		Double price = 5.00;
		Integer stock = 50;
		Mockito.doReturn(itemName, price.toString(), stock.toString()).when(itemController).getInput();
		Items item = new Items(itemName, price, stock);
		Items savedItem = new Items(1L, "carrot cake", 5.00, 50);
		Mockito.when(itemServices.create(item)).thenReturn(savedItem);
		assertEquals(savedItem, itemController.create());
		
	}
	
	@Test
	public void updateTest() {
		Long itemId = 1L;
		String itemName = "chocolate cake";
		Double price = 6.00;
		Integer stock = 50;
		Mockito.doReturn(itemId.toString(), itemName, price.toString(), stock.toString()).when(itemController).getInput();
		Items item = new Items(1L, itemName, price, stock);
		Mockito.when(itemServices.update(item)).thenReturn(item);
		assertEquals(item, itemController.update());
		
	}
	
	@Test
	public void deleteTest() {
		Long itemId = 1L;
		Mockito.doReturn(itemId.toString()).when(itemController).getInput();
		itemController.delete();
		Mockito.verify(itemServices, Mockito.times(1)).delete(1L);
	}
	
}
