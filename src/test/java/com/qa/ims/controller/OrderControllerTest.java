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

import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.services.OrderServices;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {
	
	@Mock
	private OrderServices orderServices;
	
	@Spy
	@InjectMocks
	private OrderController orderController;
	
	@Test
	public void readAllTest() {
		OrderController orderController = new OrderController(orderServices);
		List<Orders> orders = new ArrayList<>();
		orders.add(new Orders(1L, "15/01/2021"));
		orders.add(new Orders(2L, "15/01/2021"));
		orders.add(new Orders(3L, "15/01/2021"));
		Mockito.when(orderServices.readAll()).thenReturn(orders);
		assertEquals(orders, orderController.readAll());
		
	}
	
	@Test
	public void createTest() {
		Long customerId = 1L;
		String datePlaced = "15/01/2021";
		Mockito.doReturn(customerId.toString(), datePlaced).when(orderController).getInput();
		Orders order = new Orders(customerId, datePlaced);
		Orders savedOrder = new Orders(1L, 1L, "15/01/2021");
		Mockito.when(orderServices.create(order)).thenReturn(savedOrder);
		assertEquals(savedOrder, orderController.create());
	}
	
	@Test
	public void updateTest() {
		Long orderId = 1L;
		Long customerId = 1L;
		String datePlaced = "12/01/2021";
		Mockito.doReturn(orderId.toString(), customerId.toString(), datePlaced).when(orderController).getInput();
		Orders orders = new Orders(1L, customerId, datePlaced);
		Mockito.when(orderServices.update(orders)).thenReturn(orders);
		assertEquals(orders, orderController.update());
	}
	
	@Test
	public void deleteTest() {
		Long orderId = 1L;
			Mockito.doReturn(orderId.toString()).when(orderController).getInput();
			orderController.delete();
			Mockito.verify(orderServices, Mockito.times(1)).delete(1L);
	}

}
