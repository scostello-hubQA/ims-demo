package com.qa.ims.persistance.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.qa.ims.Ims;
import com.qa.ims.persistence.dao.OrderlineDaoMysql;


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
		
	}
	@Test
	public void readTest() {
		
	}
	@Test
	public void updateTest() {
		
	}
	@Test
	public void readAllTest() {
		
	}
	@Test
	public void deleteTest() {
		
	}

}
