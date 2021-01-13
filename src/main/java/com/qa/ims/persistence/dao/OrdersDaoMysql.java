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
	
	Orders ordersFromResultSet(ResultSet resultSet) throws SQLException{
		Long orderId = resultSet.getLong("order_id");
		Long customerId = resultSet.getLong("customer_id");
		String datePlaced = resultSet.getString("date_placed");
		return new Orders(orderId, customerId, datePlaced);
		
		
	}





	@Override
	public List<Orders> readAll() {
		try(Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery("select * from orders");){
			ArrayList<Orders> orders = new ArrayList<>();
			while (rs.next()){
				orders.add(ordersFromResultSet(rs));
			}
			return orders;
		}catch(SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
				
		
	}
	@Override
	public Orders create(Orders t) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Orders update(Orders t) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}
	
	

}
