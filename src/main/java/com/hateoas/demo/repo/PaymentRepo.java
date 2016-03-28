package com.hateoas.demo.repo;

import org.springframework.data.repository.Repository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.security.access.prepost.PreAuthorize;

import com.hateoas.demo.model.entity.Payment;

/**
 * An example of broadly restricting ways a resource can be manipulated.
 * 
 * Must be an user to access. Accessed via the /payments endpoint. Allow users
 * to only create/update a {@link Payment} or search for a Payment by id. Allow
 * no other interaction with orders over the web.
 * 
 * @author williamkorando
 *
 */
public interface PaymentRepo extends Repository<Payment, Long> {
	@RestResource(exported = true)
	@PreAuthorize("hasRole('ROLE_USER')")
	Payment findOne(Long id);

	@RestResource(exported = true)
	@PreAuthorize("hasRole('ROLE_USER')")
	<S extends Payment> S save(S entity);
}
