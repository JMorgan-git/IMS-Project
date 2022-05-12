package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

/**
 * Takes in item details for CRUD functionality
 *
 */
public class OrderController implements CrudController<Order> {

	public static final Logger LOGGER = LogManager.getLogger();

	private OrderDAO orderDAO;
	private Utils utils;
	private List<Item> orderItems;

	public OrderController(OrderDAO orderDAO, Utils utils) {
		super();
		this.orderDAO = orderDAO;
		this.utils = utils;
	}

	/**
	 * Reads all items to the logger
	 */
	@Override
	public List<Order> readAll() {
		List<Order> orders = orderDAO.readAll();
		for (Order order : orders) {
			LOGGER.info(order);
		}
		return orders;
	}

	/**
	 * Creates a order by taking in user input
	 */
	@Override
	public Order create() {
		LOGGER.info("Please enter your customer id");
		Long customerId = utils.getLong();
		Order order = orderDAO.create(new Order(customerId));
		LOGGER.info("Order created");

		// add new items need "menu" to select
		// add item menu

		LOGGER.info("Would you like to add items to your order?");
		LOGGER.info("Enter T).Yes or T).No");
		String newItem = utils.getString();
		addItem(newItem);

		return order;
	}

	// needs order + item loop to add as many as want...
	public Order addItem(String newItem) {
		if (newItem.toLowerCase().equals("yes")) {
			boolean loop = true;
			while (loop) {
				LOGGER.info("Please Enter your order id: ");
				Long orderId = utils.getLong();
				LOGGER.info("Please Enter the item id you wish to add: ");
				Long itemId = utils.getLong();
				orderDAO.addItem(orderId, itemId);
				LOGGER.info("Would you like to add more items?");
				LOGGER.info("Enter T).Y or T).N");
				String moreItems = utils.getString();
				if (moreItems.toLowerCase().equals("no")) {
					// Break out of the loop to stop adding items
					loop = false;
				}
			}
			return null;
		} else {
			LOGGER.info("Returning to menu");
			return null;
		}
	}

	/**
	 * Updates an existing order by taking in user input
	 */
	@Override
	public Order update() {
		LOGGER.info("Please enter the id of the order you would like to update");
		Long id = utils.getLong();
		LOGGER.info("Please enter an item id to add to your order");
		Long itemId = utils.getLong();
		Order order = orderDAO.update(new Order(id, itemId));
		LOGGER.info("Order Updated");

		return order;
	}

	/**
	 * Deletes an existing item by the id of the item
	 * 
	 * @return
	 */
	@Override
	public int delete() {

		// delete a whole order or an item from an order??? review
		LOGGER.info("Please enter the id of the order you would like to delete");
		Long id = utils.getLong();
		return orderDAO.delete(id);
	}
}
