package com.qa.ims.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.persistence.dao.Dao;
import com.qa.ims.persistence.domain.Orderline;

@RunWith(MockitoJUnitRunner.class)
public class OrderlineServicesTest {

	@Mock
	private Dao<Orderline> orderlineDao;

	@InjectMocks
	private OrderlineServices orderlineServices;

	@Test
	public void orderlineServicesCreateTest() {
		Orderline orderline = new Orderline(1L, 1L, 10);
		orderlineServices.create(orderline);
		Mockito.verify(orderlineDao, Mockito.times(1)).create(orderline);

	}

	@Test
	public void orderlineServicesReadTest() {
		orderlineServices.readAll();
		Mockito.verify(orderlineDao, Mockito.times(1)).readAll();

	}

	@Test
	public void orderlineServicesUpdateTest() {
		Orderline orderline = new Orderline(2L, 1L, 5);
		orderlineServices.update(orderline);
		Mockito.verify(orderlineDao, Mockito.times(1)).update(orderline);

	}

	@Test
	public void orderlineServicesDeleteTest() {
		orderlineServices.delete(1L);
Mockito.verify(orderlineDao, Mockito.times(1)).delete(1L);
	}
}
