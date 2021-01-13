package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.Orders;

public class OrdersDaoMysql implements Dao<Orders> {

	public static final Logger LOGGER = Logger.getLogger(OrdersDaoMysql.class);

	private String jdbcConnectionUrl;
	private String username;
	private String password;

	public OrdersDaoMysql(String username, String password) {
		this.jdbcConnectionUrl = "jdbc:mysql://localhost:3306/ims";
		this.username = username;
		this.password = password;
	}

	public OrdersDaoMysql(String jdbcConnectionUrl, String username, String password) {
		this.jdbcConnectionUrl = jdbcConnectionUrl;
		this.username = username;
		this.password = password;
	}

	Orders ordersFromResultSet(ResultSet resultSet) throws SQLException {
		Long orderId = resultSet.getLong("order_id");
		Long customerId = resultSet.getLong("customer_id");
		String datePlaced = resultSet.getString("date_placed");
		return new Orders(orderId, customerId, datePlaced);
		
	}


	

	@Override
	public List<Orders> readAll() {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery("select * from orders");) {
			ArrayList<Orders> orders = new ArrayList<>();
			while (rs.next()) {
				orders.add(ordersFromResultSet(rs));
			}
			return orders;
		} catch (SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	public Orders readLatest() {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery("select * from orders order by order_id desc limit 1");) {
			rs.next();
			return ordersFromResultSet(rs);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;

	}

	@Override
	public Orders create(Orders order) {
		try (Connection conn = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement stmt = conn.createStatement();) {
			stmt.executeUpdate("insert into orders(customer_id, date_placed) values('" + order.getCustomerId() + "','"
					+ order.getDatePlaced() + "')");
			return readLatest();
		} catch (

		Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	public Orders readOrder(Long orderId) {
		try (Connection conn = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select * from orders where order_id = " + orderId);) {
			rs.next();
			return ordersFromResultSet(rs);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());

		}
		return null;

	}

	@Override
	public Orders update(Orders order) {
		try (Connection conn = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement stmt = conn.createStatement();) {
			stmt.executeUpdate("update orders set customer_id ='" + order.getCustomerId() + "', date_placed ='"
					+ order.getDatePlaced() + "' where order_id =" + order.getOrderId());
			return readOrder(order.getOrderId());
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public void delete(long id) {
		try (Connection conn = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement stmt = conn.createStatement();) {
			stmt.executeUpdate("delete from orders where order_id = " + id);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());

		}
	}

}
