package com.hateoas.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.rest.webmvc.support.RepositoryEntityLinks;
import org.springframework.hateoas.Identifiable;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hateoas.demo.model.entity.Item;
import com.hateoas.demo.model.entity.Order;
import com.hateoas.demo.repo.ItemRepo;

@RepositoryRestController
@RequestMapping("/merchandise")
public class ItemController {

	@Autowired
	private ItemRepo itemRepo;
	@Autowired
	private RepositoryEntityLinks entityLinks;

	/**
	 * Create a link to add an Item to an existing Order or create a new Order when
	 * the user views a specific Item.
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/{id}")
	public ResponseEntity<Resource<Item>> viewItem(@PathVariable String id) {
		Item item = itemRepo.findOne(Long.valueOf(id));

		Resource<Item> resource = new Resource<Item>(item);
		if (hasExistingOrder()) {
			// Provide a link to an existing Order
			resource.add(entityLinks.linkToSingleResource(retrieveExistingOrder()).withRel("addToCart"));
		} else {
			// Provide a link to create a new Order
			resource.add(entityLinks.linkFor(Order.class).withRel("addToCart"));
		}
		resource.add(entityLinks.linkToSingleResource(item).withSelfRel());
		return ResponseEntity.ok(resource);
	}

	/**
	 * Retrieve an existing order.
	 * 
	 * @return
	 */
	private Identifiable<?> retrieveExistingOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Logic to determine if an user has an existing order.
	 * 
	 * @return
	 */
	private boolean hasExistingOrder() {
		// TODO Auto-generated method stub
		return false;
	}

}

