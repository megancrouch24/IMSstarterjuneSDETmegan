package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.qa.ims.persistence.dao.ItemsDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.Utils;


public class ItemsController implements CrudController<Item> {

	public static final Logger LOGGER = LogManager.getLogger();

	private ItemsDAO itemsDAO;
	private Utils utils;

	public ItemsController(ItemsDAO itemsDAO, Utils utils) {
		super();
		this.itemsDAO = itemsDAO;
		this.utils = utils;
	}

	
	@Override
	public List<Item> readAll() {
		List<Item> items = itemsDAO.readAll();
		for (Item item : items) {
			LOGGER.info(item);
		}
		return items;
	}

	
	@Override
	public Item create() {
		LOGGER.info("Please enter item name");
		String itemName = utils.getString();
		LOGGER.info("Please enter item id");
		Long itemId = utils.getLong();
		LOGGER.info("please enter item value");
		Double itemvalue = utils.getDouble();
		Item item = itemsDAO.create(new Item(itemId, itemName,itemvalue ));
		LOGGER.info("Item added!");
		return item;
	}

	
	@Override
	public Item update() {
		LOGGER.info("Please enter the id of the item you would like to update");
		Long id = utils.getLong();
		LOGGER.info("Please enter item_name");
		String itemName = utils.getString();
		LOGGER.info("Please enter item_id");
		Double itemvalue = utils.getDouble();
		Item item = itemsDAO.update(new Item(id, itemName, itemvalue ));
		LOGGER.info("Item Updated");
		return item;
	}

	
	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the item you would like to delete");
		Long id = utils.getLong();
		return itemsDAO.delete(id);
	}

}
