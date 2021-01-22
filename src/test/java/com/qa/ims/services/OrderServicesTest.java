package com.qa.ims.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.persistence.dao.Dao;
import com.qa.ims.persistence.domain.Orders;

@RunWith(MockitoJUnitRunner.class)
public class OrderServicesTest {
	
	@Mock
	private Dao<Orders> orderDao;
	
	@InjectMocks
	private OrderServices orderservices;
	
	@Test
	public void orderServicesCreateTest() {
		Orders order = new Orders(1L, "15/01/2021");
		orderservices.create(order);
		Mockito.verify(orderDao, Mockito.times(1)).create(order);
		
	}
	
	@Test
	public void orderServicesReadTest() {
		orderservices.readAll();
		Mockito.verify(orderDao, Mockito.times(1)).readAll();
		
	}
	
	@Test
	public void orderServicesUpdateTest() {
		Orders order = new Orders(2L, "14/01/2021");
		orderservices.update(order);
		Mockito.verify(orderDao, Mockito.times(1)).update(order);
		
	}
	@Test
	public void orderServicesDeleteTest() {
		orderservices.delete(1L);
		Mockito.verify(orderDao, Mockito.times(1)).delete(1L);
		
	}

}
