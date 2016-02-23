package com.sug.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sug.demo.model.Response;
import com.sug.demo.model.entity.Item;

@RestController
@RequestMapping("/items")
public class ItemController {

	public ResponseEntity<List<Item>> allItems(){
		return null;
	}
	
	@RequestMapping("/type/{type}")
	public ResponseEntity<List<Item>> allItemsByType(@PathVariable("type") String type){
		return null;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Response> addItem(@RequestBody Item item){
		return null;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Response> addItem(@PathVariable("id") String id, @RequestBody Item item){
		return null;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Response> deleteItem(@PathVariable("id") String id){
		return null;
	}
}
