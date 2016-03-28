package com.hateoas.demo.repo;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.security.access.prepost.PreAuthorize;

import com.hateoas.demo.model.entity.Item;

/**
 * Repository for viewing items. Accessed via the /merchandise endpoint (instead of /items). Uses a
 * PagingAndSortingRepository as there could be a lot of items and it would be
 * costly and undesirable to show all the results on one page. Users would also
 * want to be able to sort items they are searching for.
 * 
 * @author williamkorando
 *
 */
@RepositoryRestResource(collectionResourceRel = "merchandise", path = "merchandise")
public interface ItemRepo extends PagingAndSortingRepository<Item, Long> {

	Iterable<Item> findAll();

	/**
	 * Items should not be allowed to by deleted over the web.
	 */
	@RestResource(exported = false)
	@Override
	void delete(Long aLong);

	@RestResource(exported = false)
	@Override
	void delete(Item item);

	@RestResource(exported = false)
	@Override
	void delete(Iterable<? extends Item> items);

	@RestResource(exported = false)
	@Override
	void deleteAll();

	/**
	 * Only administrators should be able to make changes to an item.
	 */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@Override
	<S extends Item> S save(S entity);

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@Override
	<S extends Item> Iterable<S> save(Iterable<S> entities);

	/**
	 * Allow users to search for an item by its type.
	 * 
	 * @param type
	 * @return
	 */
	List<Item> findByType(@Param("type") String type);
}