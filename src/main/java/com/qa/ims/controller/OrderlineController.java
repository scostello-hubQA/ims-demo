package com.qa.ims.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.Orderline;
import com.qa.ims.services.CrudServices;
import com.qa.ims.utils.Utils;

public class OrderlineController implements CrudController<Orderline> {

	// convention to name the class Logger after the class itself \/
	public static final Logger LOGGER = Logger.getLogger(OrderlineController.class);

	private CrudServices<Orderline> orderlineServices;

	public OrderlineController(CrudServices<Orderline> orderlineservices) {
		this.orderlineServices = orderlineservices;
	}

	String getInput() {
		return Utils.getInput();
	}

	@Override
	public List<Orderline> readAll() {
		List<Orderline> orderline = orderlineServices.readAll();
		for (Orderline orderlines : orderline) {
			LOGGER.info(orderlines.toString());
		}
		return orderline;
	}

	@Override
	public Orderline create() {
		
		LOGGER.info("please enter a corresponding order ID");
		Long orderId = Long.valueOf(getInput());
		LOGGER.info("please enter a corresponding item ID to add to this order");
		Long itemId = Long.valueOf(getInput());
		LOGGER.info("please enter the quantity of this Item you wish to add");
		Integer quantity = Integer.valueOf(getInput());
		Orderline orderline = orderlineServices.create(new Orderline(itemId, orderId, quantity));
		LOGGER.info("your orderline is created");
		return orderline;

//		List<Long> items = new ArrayList<>();
//		List<Integer> quants = new ArrayList<>();
//		String addItems = "Y";
//
//		LOGGER.info("please enter a corresponding order ID");
//		Long orderId = Long.valueOf(getInput());
//
//		while (addItems.equals("Y")) {
//			LOGGER.info("please enter a corresponding item ID to add to this order");
//			items.add(Long.valueOf(getInput()));
//			LOGGER.info("please enter the quantity of this Item you wish to add");
//			quants.add(Integer.valueOf(getInput()));
//			LOGGER.info("do you want to continue adding items to this order? Y/N");
//			addItems = getInput().toUpperCase();
//		}
//
//		Orderline orderline = orderlineServices.create(new Orderline(orderId, items, quants));
//		LOGGER.info("your orderline is created");
//		return orderline;
	}

	@Override
	public Orderline update() {
		LOGGER.info("Please enter the corresponding orderline ID you wish to update");
		Long orderlineId = Long.valueOf(getInput());
		LOGGER.info("please enter the order ID linked with this line");
		Long orderId = Long.valueOf(getInput());
		LOGGER.info("Please enter the item ID you wish to update");
		Long itemId = Long.valueOf(getInput());
		LOGGER.info("please update the quantity of this item");
		Integer quantity = Integer.valueOf(getInput());
		Orderline orderline = orderlineServices.update(new Orderline(orderlineId, itemId, orderId, quantity));

		LOGGER.info("your orderline has been updated in line with the information given");
		return orderline;
	}

	@Override
	public void delete() {
		LOGGER.info("Please enter the ID of the orderline you wish to delete: ");
		Long orderlineId = Long.valueOf(getInput());
		orderlineServices.delete(orderlineId);

	}

}
