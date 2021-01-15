package com.qa.ims.persistance.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

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
import com.qa.ims.persistence.dao.CustomerDaoMysql;
import com.qa.ims.persistence.domain.Customer;

public class CustomerDoaMysqlTest {

	public static final Logger LOGGER = Logger.getLogger(CustomerDaoMysql.class);

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
			statement.executeUpdate("delete from imstest.customers");
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}

	@Test
	public void createTest() {
		CustomerDaoMysql customerDaoMysql = new CustomerDaoMysql(jdbcConnectionUrl, username, password);
		String fn = "sally";
		String sn = "fry";
		Customer customer = new Customer(null ,fn, sn);
		Customer savedCustomer = new Customer(null, fn, sn);
		customer = customerDaoMysql.create(customer);
		customer.setId(null);
		assertEquals(savedCustomer, customer);

	}

	@Test
	public void readTest() {
		CustomerDaoMysql customerDaoMysql = new CustomerDaoMysql(jdbcConnectionUrl, username, password);
		String fn = "sally";
		String sn = "fry";
		Customer customer = new Customer(null ,fn, sn);
		Customer savedCustomer = new Customer(null, fn, sn);
		customer = customerDaoMysql.create(customer);
		customer.setId(null);
		customerDaoMysql.readCustomer(null);
		assertEquals(savedCustomer, customer);
	}

	@Test
	public void updateTest() {
		CustomerDaoMysql customerDaoMysql = new CustomerDaoMysql(jdbcConnectionUrl, username, password);
		String fn = "sally";
		String sn = "fry";
		Customer customer = new Customer(null, fn, sn);
		Customer savedCustomer = new Customer(null, "sally", "fry");
		customer = customerDaoMysql.create(customer);
		customerDaoMysql.update(customer);
		customer.setId(null);
		assertEquals(savedCustomer, customer);

	}
	
	@Test
	public void readAllTest() {
		CustomerDaoMysql customerDaoMysql = new CustomerDaoMysql(jdbcConnectionUrl, username, password);
		String fn = "sally";
		String sn = "fry";
		Customer customer = new Customer(1l, fn, sn);
		Customer savedCustomer = new Customer(1l, fn, sn);
		List<Customer> customers = new ArrayList<>();
		customers.add(customer);
		customerDaoMysql.readAll();
		assertEquals(savedCustomer, customer);
		
	}
	
	@Test
	public void deleteTest() {
		CustomerDaoMysql customerDaoMysql = new CustomerDaoMysql(jdbcConnectionUrl, username, password);
		Long id = 1l;
		String fn = "bruce";
		String sn = "fry";
		Customer customer = new Customer(id, fn, sn);
		Customer savedCustomer = new Customer(fn, sn);
//		customerDaoMysql.create(customer);
		customerDaoMysql.delete(1l);
		assertNotEquals(savedCustomer, customer);
	}
}
