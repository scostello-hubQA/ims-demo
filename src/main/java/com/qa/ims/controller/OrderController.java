package com.qa.ims.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.services.CrudServices;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Orders> {

	public static final Logger LOGGER = Logger.getLogger(OrderController.class);
	private CrudServices<Orders> orderservice;

	public OrderController(CrudServices<Orders> orderservice) {
		this.orderservice = orderservice;

	}

	String getInput() {
		return Utils.getInput();

	}

	@Override
	public List<Orders> readAll() {
		List<Orders> orders = orderservice.readAll();
		for (Orders order : orders) {
			LOGGER.info(order.toString());
		}
		return orders;
	}

	@Override
	public Orders create() {

		LOGGER.info("please enter the customer ID to create an order");
		Long customerId = Long.valueOf(getInput());
		LOGGER.info("please enter a date this was create using DD/MM/YYYY");
		String datePlaced = getInput();
		Orders orders = orderservice.create(new Orders(customerId, datePlaced));

		LOGGER.info("Order was created");
		return orders;
	}

	@Override
	public Orders update() {
LOGGER.info("please enter the Order ID of the order you wish you update");
		Long order_id = Long.valueOf(getInput());
		LOGGER.info("Please enter the customer ID relevent to this order");
		Long customerId = Long.valueOf(getInput());
		LOGGER.info("Please update order date");
		String dateplaced = getInput();
		Orders orders = orderservice.update(new Orders(order_id, customerId, dateplaced));
		LOGGER.info("Order has been updated");
		
		return orders;
	}
		
	
		
		
			


	

	@Override
	public void delete() {
		LOGGER.info("Please enter an order ID to delete that order: ");
		Long orderId = Long.valueOf(getInput());
		orderservice.delete(orderId);
		
	}

}
