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

import com.qa.ims.persistence.domain.Orderline;
import com.qa.ims.services.OrderlineServices;


@RunWith(MockitoJUnitRunner.class)
public class OrderlineControllerTest {
	
	@Mock
	private OrderlineServices orderlineServices;
	
	@Spy
	@InjectMocks
	private OrderlineController orderlineController;
	
	@Test
	public void readAllTest() {
		OrderlineController orderlineController = new OrderlineController(orderlineServices);
		List<Orderline> orderline = new ArrayList<>();
		orderline.add(new Orderline(1L, 2L, 1L, 4, 5.00, 3L, "sam", "carrot cake"));
		orderline.add(new Orderline(1L, 2L, 1L, 4, 10.00, 2L, "sven", "carrot cake"));
		orderline.add(new Orderline(1L, 2L, 1L, 4, 6.00, 4L, "sally", "carrot cake"));
		Mockito.when(orderlineServices.readAll()).thenReturn(orderline);
		assertEquals(orderline, orderlineController.readAll());
		
	}
	
	@Test
	public void createTest() {
		Long orderId = 1L;
		Long itemId = 2L;
		Integer quantity = 3;
		Mockito.doReturn(orderId.toString(), itemId.toString(), quantity.toString()).when(orderlineController).getInput();
		Orderline orderline = new Orderline(itemId, orderId, quantity);
		Orderline savedOrderline = new Orderline(1L, 2L, 3);
		Mockito.when(orderlineServices.create(orderline)).thenReturn(savedOrderline);
		assertEquals(savedOrderline, orderlineController.create());
	}
	
	@Test
	public void updateTest() {
		Long orderlineId = 1L;
		Long orderId = 1L;
		Long itemId = 3L;
		Integer quantity = 5;
		Mockito.doReturn(orderlineId.toString(), orderId.toString(), itemId.toString(), quantity.toString()).when(orderlineController).getInput();
		Orderline orderline = new Orderline(1L, itemId, orderId, quantity);
		Mockito.when(orderlineServices.update(orderline)).thenReturn(orderline);
		assertEquals(orderline, orderlineController.update());
		
		
	}
	
	@Test
	public void deleteTest() {
		Long orderlineId = 1L;
		Mockito.doReturn(orderlineId.toString()).when(orderlineController).getInput();
		orderlineController.delete();
		Mockito.verify(orderlineServices, Mockito.times(1)).delete(1L);
		
	}

}
