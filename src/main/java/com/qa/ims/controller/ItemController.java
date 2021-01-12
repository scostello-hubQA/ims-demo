package com.qa.ims.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.Items;
import com.qa.ims.services.CrudServices;
import com.qa.ims.utils.Utils;

public class ItemController implements CrudController<Items> {

	public static final Logger LOGGER = Logger.getLogger(ItemController.class);

	private CrudServices<Items> itemservice;

	public ItemController(CrudServices<Items> itemservice) {
		this.itemservice = itemservice;
	}

	String getInput() {
		return Utils.getInput();

	}

	@Override
	public List<Items> readAll() {
		List<Items> items = itemservice.readAll();
		for (Items item : items) {
			LOGGER.info(item.toString());
		}
		return items;
	}

	@Override
	public Items create() {
		LOGGER.info("Please enter item name");
		String itemName = getInput();
		LOGGER.info("Please enter item price");
		Double price = Double.valueOf(getInput());
		LOGGER.info("Please enter item stock");
		Integer stock = Integer.valueOf(getInput());
		Items items = itemservice.create(new Items(itemName, price, stock));
		LOGGER.info("item created");
		return items;

	}

	@Override
	public Items update() {
		LOGGER.info("Please enter the ID of the item you want to update");
		Long item_id = Long.valueOf(getInput());
		LOGGER.info("Please enter item name");
		String itemName = getInput();
		LOGGER.info("Please enter item price");
		Double price = Double.valueOf(getInput());
		LOGGER.info("Please enter item stock");
		Integer stock = Integer.valueOf(getInput());
		Items items = itemservice.update(new Items(item_id, itemName, price, stock));
		LOGGER.info("item updated");
		return items;

	}

	@Override
	public void delete() {
		LOGGER.info("Please enter to ID of the item you want to delete: ");
		Long id = Long.valueOf(getInput());
		itemservice.delete(id);

	}

}
