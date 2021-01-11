package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
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
		this.jdbcConnectionUrl = "jdbc:mysql://localhost:3306/ims";
		this.username = username;
		this.password = password;
	}

	public ItemsDaoMysql(String jdbcConnectionUrl, String username, String password) {
		this.jdbcConnectionUrl = jdbcConnectionUrl;
		this.username = username;
		this.password = password;
	}

	Items itemsFromResultSet(ResultSet resultSet) throws SQLException {
		Long itemId = resultSet.getLong("id");
		String itemName = resultSet.getString("itemName");
		double price = resultSet.getDouble("Price");
		int stock = resultSet.getInt("Stock");
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
				Statement stmt = connection.createStatement();
				ResultSet resultSet = stmt.executeQuery("SELECT * FROM items ORDER BY id DESC LIMIT 1");) {
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
			stmt.executeUpdate("insert into items(itemName, price, stock) values('" + t.getItemName() + "`,`"
					+ t.getPrice() + "`,`" + t.getStock() + "`)");
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	public Items readItem(Long id) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement stmt = connection.createStatement();
				ResultSet resultSet = stmt.executeQuery("SELECT FROM items where id = " + id);) {
			resultSet.next();
			return itemsFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Items update(Items t) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement stmt = connection.createStatement();) {
			stmt.execute("update items set itemName =`" + t.getItemName() + "`price =`" + t.getPrice() + "`stock = `"
					+ t.getStock() + "`where item_id = `" + t.getItem_id());
			return readItem(t.getItem_id());

		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public void delete(long id) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement stmt = connection.createStatement();) {
			stmt.executeUpdate("delete from items where id = " + id);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());

		}

	}

}
