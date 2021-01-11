package com.qa.ims.services;

import java.util.List;

import com.qa.ims.persistence.dao.Dao;
import com.qa.ims.persistence.domain.Items;

public class ItemServices implements CrudServices<Items> {
	
	private Dao<Items> itemDao;
	
	public ItemServices(Dao<Items> itemDao) {
		this.itemDao = itemDao;
		
	}

	public List<Items> readAll() {
		return itemDao.readAll();
	}
	
	public Items create(Items t) {
		return itemDao.create(t);
	}

	
	public Items update(Items t) {
	return itemDao.update(t);
	}

	
	public void delete(Long id) {
		itemDao.delete(id);
		
	}

}
