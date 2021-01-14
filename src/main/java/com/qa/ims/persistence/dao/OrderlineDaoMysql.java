package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.Orderline;

public class OrderlineDaoMysql implements Dao<Orderline> {

	public static final Logger LOGGER = Logger.getLogger(OrderlineDaoMysql.class);

	private String jdbcConnectionUrl;
	private String username;
	private String password;

	public OrderlineDaoMysql(String username, String password) {
		this.jdbcConnectionUrl = "jdbc:mysql://localhost:3306/ims";
		this.username = username;
		this.password = password;
	}

	public OrderlineDaoMysql(String jdbcConnectionUrl, String username, String password) {
		super();
		this.jdbcConnectionUrl = jdbcConnectionUrl;
		this.username = username;
		this.password = password;
	}

	Orderline orderlineFromResultSet(ResultSet resultSet) throws SQLException {
		Long orderlineId = resultSet.getLong("orderline_id");
		Long itemId = resultSet.getLong("item_id");
		Long orderId = resultSet.getLong("order_id");
		Integer quantity = resultSet.getInt("quantity");
		Double totalPrice = resultSet.getDouble("total_price");
		Double price = resultSet.getDouble("price");
		Long customer_id = resultSet.getLong("customer_id");
		String first_name = resultSet.getString("first_name");
		return new Orderline(orderlineId, itemId, orderId, quantity, totalPrice, price, customer_id, first_name);

	}

	@Override
	public List<Orderline> readAll() {
		try (Connection conn = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select ol.orderline_id, ol.order_id, ol.item_id, ol.quantity, ol.total_price, items.price, cu.customer_id, cu.first_name from orderline ol join orders on orders.order_id=ol.order_id join items on items.item_id=ol.item_id join customers cu on cu.customer_id=orders.customer_id");) {
			ArrayList<Orderline> orderline = new ArrayList<>();
			while (rs.next()) {
				orderline.add(orderlineFromResultSet(rs));
			}
			return orderline;
		} catch (SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());

		}
		return new ArrayList<>();
		
	}
	
		Orderline orderlineFromResultSet1(ResultSet resultSet1) throws SQLException {
			Long orderlineId = resultSet1.getLong("orderline_id");
			Long itemId = resultSet1.getLong("item_id");
			Long orderId = resultSet1.getLong("order_id");
			Integer quantity = resultSet1.getInt("quantity");
			Double totalPrice = resultSet1.getDouble("total_price");
			return new Orderline(orderlineId, itemId, orderId, quantity, totalPrice);
	}

	public Orderline readLatest() {
		try (Connection conn = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select * from orderline order by orderline_id desc limit 1");) {
			rs.next();
			return orderlineFromResultSet1(rs);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Orderline create(Orderline orderline) {
		try (Connection conn = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement stmt = conn.createStatement();) {
			stmt.executeUpdate("insert into orderline(item_id, order_id, quantity, total_price) values('"
					+ orderline.getItemId() + "','" + orderline.getOrderId() + "','" + orderline.getQuantity() + "','"
					+ orderline.getTotalPrice() + "')");
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());

		}
		return null;
	}

	public Orderline readOrderline(Long orderlineId) {
		try (Connection conn = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select * from orderline where orderline_id = " + orderlineId);) {
			rs.next();
			return orderlineFromResultSet1(rs);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());

		}
		return null;
	}

	@Override
	public Orderline update(Orderline orderline) {
		try (Connection conn = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement stmt = conn.createStatement();){
			stmt.executeUpdate("update orderline set item_id = '" + orderline.getItemId() + "', order_id ='" + orderline.getOrderId() + "', quantity ='" + orderline.getQuantity() + "', total_price ='" + orderline.getTotalPrice() + "' where orderline_id =" + orderline.getOrderlineId());
			return readOrderline(orderline.getOrderlineId());
		}catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public void delete(long id) {
		try (Connection conn = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement stmt = conn.createStatement();) {
			stmt.executeUpdate("delete from orderline where orderline_id = " + id);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());

		}

	}

}
