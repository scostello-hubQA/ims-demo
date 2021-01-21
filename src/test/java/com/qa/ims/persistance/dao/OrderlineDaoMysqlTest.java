package com.qa.ims.persistance.dao;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.qa.ims.Ims;
import com.qa.ims.persistence.dao.OrderlineDaoMysql;
//import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Orderline;

public class OrderlineDaoMysqlTest {

	public static final Logger LOGGER = Logger.getLogger(OrderlineDaoMysql.class);

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
			statement.executeUpdate("delete from imstest.orderline");
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}

	@Test
	public void createTest() {
		OrderlineDaoMysql orderlineDaoMysql = new OrderlineDaoMysql(jdbcConnectionUrl, username, password);
		Long itemId = 1l;
		Long orderId = 1l;
		Integer quantity = 2;
		Orderline orderline = new Orderline(itemId, orderId, quantity);
		Orderline savedOrderline = new Orderline(itemId, orderId, quantity);
		orderlineDaoMysql.create(orderline);
		assertEquals(savedOrderline, orderline);
		

	}

	@Test
	public void readTest() {
		OrderlineDaoMysql orderlineDaoMysql = new OrderlineDaoMysql(jdbcConnectionUrl, username, password);
		Long itemId = 1l;
		Long orderId = 1l;
		Integer quantity = 2;
		Orderline orderline = new Orderline(itemId, orderId, quantity);
		Orderline savedOrderline = new Orderline(itemId, orderId, quantity);
		orderlineDaoMysql.readOrderline(1l);
		assertEquals(savedOrderline, orderline);

	}

	@Test
	public void updateTest() {
		OrderlineDaoMysql orderlineDaoMysql = new OrderlineDaoMysql(jdbcConnectionUrl, username, password);
		Long itemId = 1l;
		Long orderId = 1l;
		Integer quantity = 2;
		Orderline orderline = new Orderline(itemId, orderId, quantity);
		Orderline savedOrderline = new Orderline(itemId, orderId, quantity);
		orderlineDaoMysql.update(orderline);
		assertEquals(savedOrderline, orderline);

	}

	@Test
	public void readAllTest() {
		OrderlineDaoMysql orderlineDaoMysql = new OrderlineDaoMysql(jdbcConnectionUrl, username, password);
		Long itemId = 1l;
		Long orderId = 1l;
		Integer quantity = 2;
		Orderline orderline = new Orderline(itemId, orderId, quantity);
		Orderline savedOrderline = new Orderline(itemId, orderId, quantity);
		List<Orderline> orderlines = new ArrayList<>();
		orderlines.add(orderline);
		orderlines.add(savedOrderline);
		orderlineDaoMysql.readAll();
		assertEquals(savedOrderline, orderline);

	}

	@Test
	public void deleteTest() {
		OrderlineDaoMysql orderlineDaoMysql = new OrderlineDaoMysql(jdbcConnectionUrl, username, password);
		Long itemId = 1l;
		Long orderId = 1l;
		Integer quantity = 2;
		Orderline orderline = new Orderline(itemId, orderId, quantity);
		Orderline savedOrderline = new Orderline(itemId, orderId, quantity);
		orderlineDaoMysql.delete(1l);
		assertEquals(savedOrderline, orderline);

	}
}
