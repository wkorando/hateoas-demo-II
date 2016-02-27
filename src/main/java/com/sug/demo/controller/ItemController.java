package com.sug.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sug.demo.model.Response;
import com.sug.demo.model.entity.Item;
import com.sug.demo.service.ItemService;

@RestController
@RequestMapping("/items")
public class ItemController {
	@Autowired
	private ItemService itemService;

	@RequestMapping
	public ResponseEntity<Response<List<Item>>> allItems() {
		Response<List<Item>> response = itemService.findAllItems();
		ResponseEntity<Response<List<Item>>> responseEntity = new ResponseEntity<>(response, response.getHttpStatus());
		return responseEntity;
	}
	
	@RequestMapping
	public ResponseEntity<Response<List<Item>>> findItemsByType(@RequestParam("type") String type) {
		Response<List<Item>> response = itemService.findAllItems();
		ResponseEntity<Response<List<Item>>> responseEntity = new ResponseEntity<>(response, response.getHttpStatus());
		return responseEntity;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Response<Item>> addItem(@RequestBody Item item) {
		Response<Item> response = itemService.createItem(item);
		ResponseEntity<Response<Item>> responseEntity = new ResponseEntity<>(response, response.getHttpStatus());
		return responseEntity;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Response<Item>> updateItem(@PathVariable("id") Long id, @RequestBody Item item) {
		Response<Item> response = itemService.updateItem(id, item);
		ResponseEntity<Response<Item>> responseEntity = new ResponseEntity<>(response, response.getHttpStatus());
		return responseEntity;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Response<String>> deleteItem(@PathVariable("id") Long id) {
		Response<String> response = itemService.deleteItem(id);
		ResponseEntity<Response<String>> responseEntity = new ResponseEntity<>(response, response.getHttpStatus());
		return responseEntity;
	}
}
