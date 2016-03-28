package com.hateoas.demo.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hateoas.demo.model.entity.Item;
import com.hateoas.demo.model.entity.Order;
import com.hateoas.demo.repo.ItemRepo;
import com.hateoas.demo.repo.OrderRepo;

/**
 * Example of how Spring-Data-REST and Spring-HATEOAS can be used to add further
 * customizations to how Spring-Data-REST by default presents a resource.
 * 
 * @author williamkorando
 *
 */
@RepositoryRestController
public class ItemController {

	@Autowired
	private ItemRepo itemRepo;

	@RequestMapping("/{id}")
	public ResponseEntity<?> viewItem(@PathVariable String id) {
		Item item = itemRepo.findOne(Long.valueOf(id));

		Resource<Item> resource = new Resource<Item>(item);

		resource.add(linkTo(methodOn(OrderRepo.class).save(new Order())).withRel("addToCart"));
		return ResponseEntity.ok(resource);
	}

}
