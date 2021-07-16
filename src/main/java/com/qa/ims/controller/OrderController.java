package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.qa.ims.persistence.dao.OrdersDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Order> {

	public static final Logger LOGGER = LogManager.getLogger();

	private OrdersDAO ordersDAO;
	private Utils utils;

	public OrderController(OrdersDAO ordersDAO, Utils utils) {
		super();
		this.ordersDAO = ordersDAO;
		this.utils = utils;
	}

	@Override
	public List<Order> readAll() {
		List<Order> orders = ordersDAO.readAll();
		for (Order order : orders) {
			LOGGER.info(order);
		}
		return orders;
	}

	
	@Override
	public Order create() {
		LOGGER.info("Please enter order id");
		Long orderId = utils.getLong();
		LOGGER.info("Please enter customer_id");
		Long customerId = utils.getLong();
		Order order = ordersDAO.create(new Order(orderId, customerId));
		LOGGER.info("Order created");
		return order;
	}

	
	@Override
	public Order update() {
		LOGGER.info("Please enter the customer id for the order you would like to update");
		Long customerid = utils.getLong();
		LOGGER.info("Please enter order id ");
		Long orderid = utils.getLong();
		Order order = ordersDAO.update(new Order(orderid, customerid));
		LOGGER.info("Order Updated");
		return order;
	}

	
	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the order you would like to delete");
		Long id = utils.getLong();
		return ordersDAO.delete(id);
	}

}
