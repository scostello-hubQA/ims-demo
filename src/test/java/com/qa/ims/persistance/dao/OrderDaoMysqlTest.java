package com.qa.ims.persistance.dao;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.qa.ims.Ims;
import com.qa.ims.persistence.dao.OrdersDaoMysql;
import com.qa.ims.persistence.domain.Orders;

public class OrderDaoMysqlTest {
	
	public static final Logger LOGGER = Logger.getLogger(OrdersDaoMysql.class);

	private static String jdbcConnectionUrl = "jdbc:mysql://localhost:3306/imstest";
	private static String username = "root";
	private static String password = "root";

	@BeforeClass
	public static void init() {
		Ims ims = new Ims();
		ims.init(jdbcConnectionUrl, username, password, "src/test/resources/sql-schema.sql");
	}

	@Before
	public void setUp() throws SQLException {
		Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement(); {
			statement.executeUpdate("delete from imstest.orders");

		}
	}
	
	@Test
	public void createTest() {
		OrdersDaoMysql orderDaoMysqlTest = new OrdersDaoMysql(jdbcConnectionUrl, username, password);
		Long customerId = 1L;
		String datePlaced = "15/01/2021";
		Orders order = new Orders(1L, customerId, datePlaced);
		Orders savedOrder = new Orders(1L, customerId, datePlaced);
		orderDaoMysqlTest.create(order);
		order.setOrderId(1L);
		assertEquals(savedOrder, order);
		
	}
	@Test
	public void readTest() {
		OrdersDaoMysql orderDaoMysqlTest = new OrdersDaoMysql(jdbcConnectionUrl, username, password);
		Long customerId = 1L;
		String datePlaced = "15/01/2021";
		Orders order = new Orders(1L, customerId, datePlaced);
		Orders savedOrder = new Orders(1L, customerId, datePlaced);
//		orderDaoMysqlTest.create(order);
		order.setOrderId(1L);
		orderDaoMysqlTest.readOrder(1L);
		assertEquals(savedOrder, order);
		
	}
	@Test
	public void updateTest() {
		OrdersDaoMysql orderDaoMysqlTest = new OrdersDaoMysql(jdbcConnectionUrl, username, password);
		Long customerId = 1L;
		String datePlaced = "15/01/2021";
		Orders order = new Orders(1L, customerId, datePlaced);
		Orders savedOrder = new Orders(1L, customerId, datePlaced);
//		orderDaoMysqlTest.create(order);
		order.setOrderId(1L);
		orderDaoMysqlTest.update(order);
		assertEquals(savedOrder, order);
		
	}
	@Test
	public void readAllTest() {
		OrdersDaoMysql orderDaoMysqlTest = new OrdersDaoMysql(jdbcConnectionUrl, username, password);
		Long customerId = 1L;
		String datePlaced = "15/01/2021";
		Orders order = new Orders(1L, customerId, datePlaced);
		Orders savedOrder = new Orders(1L, customerId, datePlaced);
		List<Orders> orders = new ArrayList<>();
		orders.add(order);
		orders.add(savedOrder);
		orderDaoMysqlTest.readAll();
		assertEquals(savedOrder, order);
		
	}
	@Test
	public void deleteTest() {
		OrdersDaoMysql orderDaoMysqlTest = new OrdersDaoMysql(jdbcConnectionUrl, username, password);
		Long customerId = 1L;
		String datePlaced = "15/01/2021";
		Orders order = new Orders(1L, customerId, datePlaced);
		Orders savedOrder = new Orders(1L, customerId, datePlaced);
//		orderDaoMysqlTest.create(order);
//		order.setOrderId(1L);
		orderDaoMysqlTest.delete(1L);
		assertEquals(savedOrder, order);
		
	}


}
