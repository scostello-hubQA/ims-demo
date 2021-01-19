package com.qa.ims;

import org.apache.log4j.Logger;

import com.qa.ims.controller.Action;
import com.qa.ims.controller.CrudController;
import com.qa.ims.controller.CustomerController;
import com.qa.ims.controller.ItemController;
import com.qa.ims.controller.OrderController;
import com.qa.ims.controller.OrderlineController;
import com.qa.ims.persistence.dao.CustomerDaoMysql;
import com.qa.ims.persistence.dao.ItemsDaoMysql;
import com.qa.ims.persistence.dao.OrderlineDaoMysql;
import com.qa.ims.persistence.dao.OrdersDaoMysql;
import com.qa.ims.persistence.domain.Domain;
import com.qa.ims.services.CustomerServices;
import com.qa.ims.services.ItemServices;
import com.qa.ims.services.OrderServices;
import com.qa.ims.services.OrderlineServices;
import com.qa.ims.utils.Utils;

public class Admin {
	
	public static final Logger LOGGER = Logger.getLogger(Admin.class);

	
	public void adminLogIn() {
		LOGGER.info("Please enter your admin username");
		String username = Utils.getInput();
		LOGGER.info("please enter your admin pasword");
		String password = Utils.getInput();
		
		
		if(username.toLowerCase().equals("hello") && password.toLowerCase().equals("hello")); {
			
			LOGGER.info("Which entity would you like to use?");
			Domain.printDomains();

			Domain domain = Domain.getDomain();
			if (domain.name() == "STOP") {
				LOGGER.info("Goodbye");
				System.exit(0);
			}

			LOGGER.info("What would you like to do with " + domain.name().toLowerCase() + ":");

			Action.printActions();
			Action action = Action.getAction();

			switch (domain) {
			case CUSTOMER:
				CustomerController customerController = new CustomerController(
						new CustomerServices(new CustomerDaoMysql(username, password)));
				doAction(customerController, action);
				break;
			case ITEM:
				ItemController itemController = new ItemController(
						new ItemServices(new ItemsDaoMysql(username, password)));
				doAction(itemController, action);
				break;
			case ORDER:
				OrderController orderController = new OrderController(
						new OrderServices(new OrdersDaoMysql(username, password)));
				doAction(orderController, action);
				break;
			case ORDERLINE:
				OrderlineController orderlineController = new OrderlineController(
						new OrderlineServices(new OrderlineDaoMysql(username, password)));
				doAction(orderlineController, action);
				break;
			case STOP:
				break;
			default:
				break;
			}}
			}
			
			public void doAction(CrudController<?> crudController, Action action) {
				switch (action) {
				case CREATE:
					crudController.create();
					break;
				case READ:
					crudController.readAll();
					break;
				case UPDATE:
					crudController.update();
					break;
				case DELETE:
					crudController.delete();
					break;
				case RETURN:
					break;
				default:
					break;
				}
			}}
			

