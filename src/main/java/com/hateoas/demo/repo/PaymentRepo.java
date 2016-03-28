package com.hateoas.demo.repo;

import org.springframework.data.repository.Repository;
import org.springframework.security.access.prepost.PreAuthorize;

import com.hateoas.demo.model.entity.Payment;

/**
 * An example of broadly restricting ways a resource can be manipulated by using
 * the Repository interface and implementing only what we want to allow access
 * to.
 * 
 * Must be an user to access. Accessed via the /payments endpoint. Allow users
 * to only create/update a {@link Payment} or search for a Payment by id. Allow
 * no other interaction with orders over the web.
 * 
 * @author williamkorando
 *
 */
@PreAuthorize("hasRole('ROLE_USER')")
public interface PaymentRepo extends Repository<Payment, Long> {
	Payment findOne(Long id);

	<S extends Payment> S save(S entity);
}
