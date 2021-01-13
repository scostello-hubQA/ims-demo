package com.qa.ims.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.mysql.cj.x.protobuf.MysqlxCrud.Order;
import com.qa.ims.persistence.domain.Orderline;
import com.qa.ims.services.CrudServices;
import com.qa.ims.utils.Utils;

public class OrderlineController implements CrudController<Orderline> {
	
	public static final Logger LOGGER = Logger.getLogger(Orderline.class);
	
	private CrudServices<Orderline> orderlineServices;
	
	public OrderlineController (CrudServices<Orderline> orderlineservices) {
		this.orderlineServices = orderlineservices;
	}
	
	String getInput() {
		return Utils.getInput();
	}

	@Override
	public List<Orderline> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Orderline create() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Orderline update() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

}
