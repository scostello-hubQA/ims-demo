package com.qa.ims.persistance.dao;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertNotSame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.qa.ims.Ims;
import com.qa.ims.persistence.dao.ItemsDaoMysql;
import com.qa.ims.persistence.domain.Items;

public class ItemDaoMysqlTest {
	
	public static final Logger LOGGER = Logger.getLogger(ItemsDaoMysql.class);

	private static String jdbcConnectionUrl = "jdbc:mysql://localhost:3306/imstest";
	private static String username = "root";
	private static String password = "root";

	@BeforeClass
	public static void init() {
		Ims ims = new Ims();
		ims.init(jdbcConnectionUrl, username, password, "src/test/resources/sql-schema.sql");
	}

	@Before
	public void setUp() {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("delete from imstest.items");
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}
	
	@Test
	public void createTest() {
		ItemsDaoMysql itemsDaoMysql = new ItemsDaoMysql(jdbcConnectionUrl, username, password);
		String itemName = "carrot cake";
		double price = 3.00;
		int stock = 100;
		Items item = new Items(1l, itemName, price, stock);
		Items savedItem = new Items(1l, itemName, price, stock);
		item = itemsDaoMysql.create(item);
		item.setItemId(1l);
		assertEquals(savedItem, item);
		
	}
	@Test
	public void readTest() {
		ItemsDaoMysql itemsDaoMysql = new ItemsDaoMysql(jdbcConnectionUrl, username, password);
		String itemName = "carrot cake";
		double price = 3.00;
		int stock = 100;
		Items item = new Items(1l, itemName, price, stock);
		Items savedItem = new Items(1l, itemName, price, stock);
		item = itemsDaoMysql.create(item);
		item.setItemId(1l);
		itemsDaoMysql.readItem(1l);
		assertEquals(savedItem, item);
	

}
	
	@Test
	public void updateTest() {
		ItemsDaoMysql itemsDaoMysql = new ItemsDaoMysql(jdbcConnectionUrl, username, password);
		String itemName = "carrot cake";
		double price = 3.00;
		int stock = 100;
		Items item = new Items(1l, itemName, price, stock);
		Items savedItem = new Items(1l, itemName, price, stock);
		item = itemsDaoMysql.create(item);
		item.setItemId(1l);
		itemsDaoMysql.update(item);
		assertEquals(savedItem, item);
		
	}
	
	@Test
	public void readAllTest() {
		ItemsDaoMysql itemsDaoMysql = new ItemsDaoMysql(jdbcConnectionUrl, username, password);
		String itemName = "carrot cake";
		double price = 3.00;
		int stock = 100;
		Items item = new Items(1l, itemName, price, stock);
		Items savedItem = new Items(1l, itemName, price, stock);
		List<Items> items = new ArrayList<>();
		items.add(item);
		items.add(savedItem);
		itemsDaoMysql.readAll();
		assertEquals(savedItem, item);
		
	}
	
	@Test
	public void deleteTest() {
		ItemsDaoMysql itemsDaoMysql = new ItemsDaoMysql(jdbcConnectionUrl, username, password);
		Long id = 1l;
		String itemName = "carrot cake";
		double price = 3.00;
		int stock = 100;
		Items item = new Items(id, itemName, price, stock);
		Items savedItem = new Items(1l, itemName, price, stock);
		itemsDaoMysql.create(item);
		item.setItemId(1l);
		itemsDaoMysql.delete(1l);
		assertNotSame(savedItem, item);
	}
	

}
