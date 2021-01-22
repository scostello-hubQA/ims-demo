package com.qa.ims.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.persistence.dao.Dao;
import com.qa.ims.persistence.domain.Items;

@RunWith(MockitoJUnitRunner.class)
public class ItemServicesTest {
	@Mock
	private Dao<Items> itemDao;
	
	@InjectMocks
	private ItemServices itemServices;
	
	@Test
	public void itemServicesCreateTest() {
		Items item = new Items("victoria sponge", 10.00, 50);
		itemServices.create(item);
		Mockito.verify(itemDao, Mockito.times(1)).create(item);
		
	}
	@Test
	public void itemServicesReadTest() {
		itemServices.readAll();
		Mockito.verify(itemDao, Mockito.times(1)).readAll();
		
	}
	
	@Test
	public void itemServicesUpdateTest() {
		Items item = new Items("carrot cake", 5.00, 10);
		itemServices.update(item);
		Mockito.verify(itemDao, Mockito.times(1)).update(item);
		
	}
	
	@Test
	public void itemServicesDeleteTest() {
		itemServices.delete(1L);
		Mockito.verify(itemDao, Mockito.times(1)).delete(1L);
		
	}

}
