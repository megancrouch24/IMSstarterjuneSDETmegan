package com.qa.ims.persistence.dao;
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.ArrayList;
	import java.util.List;

	import org.apache.logging.log4j.LogManager;
	import org.apache.logging.log4j.Logger;
	import com.qa.ims.persistence.domain.Order;
	import com.qa.ims.utils.DBUtils;

	public class OrdersDAO implements Dao<Order> {

		public static final Logger LOGGER = LogManager.getLogger();

		@Override
		public Order modelFromResultSet(ResultSet resultSet) throws SQLException {
			Long orderid = resultSet.getLong("order_id");
			Long customerid = resultSet.getLong("customer_id");
			
			return new Order(orderid, customerid);
		}

		@Override
		public List<Order> readAll() {
			try (Connection connection = DBUtils.getInstance().getConnection();
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery("SELECT * FROM order");) {
				List<Order> orders = new ArrayList<>();
				while (resultSet.next()) {
					Order.add(modelFromResultSet(resultSet));
				}
				return orders;
			} catch (SQLException e) {
				LOGGER.debug(e);
				LOGGER.error(e.getMessage());
			}
			return new ArrayList<>();
		}

		public Order readLatest() {
			try (Connection connection = DBUtils.getInstance().getConnection();
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement
							.executeQuery("SELECT * FROM order ORDER BY order_id DESC LIMIT 1");) {
				resultSet.next();
				return modelFromResultSet(resultSet);
			} catch (Exception e) {
				LOGGER.debug(e);
				LOGGER.error(e.getMessage());
			}
			return null;
		}

		@Override
		public Order create (Order order) {
			try (Connection connection = DBUtils.getInstance().getConnection();
					PreparedStatement statement = connection
							.prepareStatement("INSERT INTO order(customer_id,) VALUES (?, ?)");) {
				statement.setLong(1, order.getCustomerid());
				statement.setDouble(2, order.getOrderid());
				statement.executeUpdate();
				return readLatest();
			} catch (Exception e) {
				LOGGER.debug(e);
				LOGGER.error(e.getMessage());
			}
			return null;
		}

		@Override
		public Order read(Long id) {
			try (Connection connection = DBUtils.getInstance().getConnection();
					PreparedStatement statement = connection
							.prepareStatement("SELECT * FROM order WHERE order_id = ?");) {
				statement.setLong(1, id);
				try (ResultSet resultSet = statement.executeQuery();) {
					resultSet.next();
					return modelFromResultSet(resultSet);
				}
			} catch (Exception e) {
				LOGGER.debug(e);
				LOGGER.error(e.getMessage());
			}
			return null;
		}

		@Override
		public Order update(Order order) {
			try (Connection connection = DBUtils.getInstance().getConnection();
					PreparedStatement statement = connection
							.prepareStatement("UPDATE items SET customer_id = ? WHERE order_id = ?");) {
				statement.setLong(1, order.getCustomerid());
				statement.setLong(3, order.getOrderid());
				statement.executeUpdate();
				return read(order.getOrderid());
			} catch (Exception e) {
				LOGGER.debug(e);
				LOGGER.error(e.getMessage());
			}
			return null;
		}


		@Override
		public int delete(long id) {
			try (Connection connection = DBUtils.getInstance().getConnection();
					PreparedStatement statement = connection
							.prepareStatement("DELETE FROM order WHERE order_id = ?");) {
				statement.setLong(1, id);
				return statement.executeUpdate();
			} catch (Exception e) {
				LOGGER.debug(e);
				LOGGER.error(e.getMessage());
			}
			return 0;
		}

		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

