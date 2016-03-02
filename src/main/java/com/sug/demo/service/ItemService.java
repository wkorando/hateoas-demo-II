package com.sug.demo.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.sug.demo.model.Response;
import com.sug.demo.model.entity.Item;
import com.sug.demo.repo.ItemRepo;

@Service
public class ItemService {
	private Logger LOG = Logger.getLogger(ItemService.class);

	@Autowired
	private ItemRepo itemRepo;

	public Response<List<Item>> findAllItems() {
		Response<List<Item>> response = new Response<>();
		try {
			List<Item> items = itemRepo.findAll();
			if (!items.isEmpty()) {
				response.setResponseBody(items);
			} else {
				response.setHttpStatus(HttpStatus.NOT_FOUND);
			}

		} catch (Exception exception) {
			LOG.error("Error occurred while attempting to retrieve items.", exception);
			response.setMessage("An error occurred while attempting to retrieve items. Please try again later.");
			response.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	public Item findItemById(long id) {
		return itemRepo.findOne(id);
	}

	public List<Item> findItemByType(String type) {
		return itemRepo.findByType(type);
	}

	public Response<Item> createItem(Item item) {
		Response<Item> response = new Response<>();
		try {
			itemRepo.save(item);
		} catch (Exception exception) {
			LOG.error("Error occurred while attempting to save item: " + (item != null ? item.toString() : null),
					exception);
			response.setMessage("An error occurred while attempting to save item: "
					+ (item != null ? item.toString() : null) + " Verify your input or please try again later.");
			response.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	public Response<Item> updateItem(Long id, Item item) {
		Response<Item> response = new Response<>();
		try {
			if (itemRepo.exists(id)) {
				item.setId(id);
				itemRepo.save(item);
			} else {
				response.setMessage("An item with id " + id + " does not exist.");
				response.setHttpStatus(HttpStatus.NOT_FOUND);
			}
		} catch (Exception exception) {
			LOG.error("Error occurred while attempting to save item: " + (item != null ? item.toString() : null),
					exception);
			response.setMessage("An error occurred while attempting to update item: "
					+ (item != null ? item.toString() : null) + " Verify your input or please try again later.");
			response.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	public Response<String> deleteItem(Long id) {
		Response<String> response = new Response<>();
		try {
			if (itemRepo.exists(id)) {
				itemRepo.delete(id);
			} else {
				response.setMessage("An item with id " + id + " does not exist or has already been deleted");
				response.setHttpStatus(HttpStatus.NOT_FOUND);
			}
		} catch (Exception exception) {
			LOG.error("Error occurred while attempting to delete item with id: " + id, exception);
			response.setMessage("An error occurred while attempting to delete item: " + id
					+ " Verify your input or please try again later.");
			response.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}
}
