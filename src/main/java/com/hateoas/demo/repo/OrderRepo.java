package com.hateoas.demo.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.security.access.prepost.PreAuthorize;

import com.hateoas.demo.model.entity.Order;

/**
 * An example of broadly restricting the ways a resource can be manipulated by
 * using annotations at the Type level.
 * 
 * Must be an user to access. Accessed via the /orders endpoint. Allow users to
 * only create/update an order or search for an order by id. Allow no other
 * interaction with orders over the web.
 * 
 * @author williamkorando
 * @see PaymentRepo
 */
@PreAuthorize("hasRole('USER')")
public interface OrderRepo extends CrudRepository<Order, Long> {

	@Override
	@RestResource(exported = true)
	Order findOne(Long id);

	@Override
	@RestResource(exported = true)
	<S extends Order> S save(S entity);
}
