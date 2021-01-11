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
		for(Items item:items) {
			LOGGER.info(item.toString());
		}
		return items;
	}

	@Override
	public Items create() {
		LOGGER.info("Please enter item name");
		LOGGER.info("Please enter item price");
		LOGGER.info("Please enter item stock");
		return null;
	}

	@Override
	public Items update() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

}
