package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;


import com.qa.ims.persistence.domain.Items;

public class ItemsDaoMysql implements Dao<Items> {
	public static final Logger LOGGER = Logger.getLogger(ItemsDaoMysql.class);

	private String jdbcConnectionUrl;
	private String username;
	private String password;

	public ItemsDaoMysql(String username, String password) {
		this.jdbcConnectionUrl = "jdbc:mysql://35.242.159.83/ims";
		this.username = username;
		this.password = password;
	}

	public ItemsDaoMysql(String jdbcConnectionUrl, String username, String password) {
		this.jdbcConnectionUrl = jdbcConnectionUrl;
		this.username = username;
		this.password = password;
	}

	Items itemsFromResultSet(ResultSet resultSet) throws SQLException {
		Long itemId = resultSet.getLong("item_id");
		String itemName = resultSet.getString("item_name");
		double price = resultSet.getDouble("price");
		int stock = resultSet.getInt("stock");
		return new Items(itemId, itemName, price, stock);

	}

	@Override
	public List<Items> readAll() {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement stmt = connection.createStatement();
				ResultSet resultSet = stmt.executeQuery("select * from items");) {
			ArrayList<Items> items = new ArrayList<>();
			while (resultSet.next()) {
				items.add(itemsFromResultSet(resultSet));

			}
			return items;
		} catch (SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	public Items readLatest() {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM items ORDER BY item_id DESC LIMIT 1");) {
			resultSet.next();
			return itemsFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Items create(Items t) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement stmt = connection.createStatement();) {
			stmt.executeUpdate("insert into items(item_name, price, stock) values('" + t.getItemName() + "','"
					+ t.getPrice() + "','" + t.getStock() + "')");
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	public Items readItem(Long itemId) {
		String query = "SELECT * FROM items WHERE item_id = ?";
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				PreparedStatement stmt = connection.prepareStatement(query);){
			stmt.setLong(1, itemId);
			try(ResultSet rs = stmt.executeQuery();){
				rs.next();
				return itemsFromResultSet(rs);
				
			}
				
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

//	@Override
//	public Items update(Items t) {
//		String query = "UPDATE items SET item_name = ?, price = ?, stock = ? WHERE item_id = ?";
//		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
//				PreparedStatement stmt = connection.prepareStatement(query);){
//			stmt.setString(1, t.getItemName());
//			stmt.setDouble(2, t.getPrice());
//			stmt.setInt(3, t.getStock());
//			stmt.setLong(4, t.getItemId());
//		} catch (Exception e) {
//			LOGGER.debug(e.getStackTrace());
//			LOGGER.error(e.getMessage());
//		}
//		return null;



	@Override
	public void delete(long id) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement stmt = connection.createStatement();) {
			stmt.executeUpdate("delete from items where item_id = " + id);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());

		}

	}

	@Override
	public Items update(Items t) {
		try (Connection conn = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement stmt = conn.createStatement();){
			
			stmt.executeUpdate("update items set item_name ='" + t.getItemName() + "', price = '" + t.getPrice() + "', stock ='" + t.getStock() + "' where item_id =" + t.getItemId());
			return readItem(t.getItemId());
		}catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
			
		}
		return null;
	}

}
