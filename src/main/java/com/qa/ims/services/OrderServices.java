package com.qa.ims.services;

import java.util.List;

import com.qa.ims.persistence.dao.Dao;
import com.qa.ims.persistence.domain.Orders;

public class OrderServices implements CrudServices<Orders> {
	
	private Dao<Orders> orderDao;
	
	public OrderServices(Dao<Orders> orderDao) {
		this.orderDao = orderDao;
		
	}

	@Override
	public List<Orders> readAll() {
		
		return orderDao.readAll();
	}

	@Override
	public Orders create(Orders order) {
		return orderDao.create(order);
	}

	@Override
	public Orders update(Orders order) {
		return orderDao.update(order);
		
	}

	@Override
	public void delete(Long id) {
		orderDao.delete(id);
		
	}

}
