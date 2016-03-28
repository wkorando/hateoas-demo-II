package com.hateoas.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.security.access.prepost.PreAuthorize;

import com.hateoas.demo.model.entity.Item;

/**
 * 
 * Repository for viewing {@link Item}s. Accessed via the /merchandise endpoint
 * (instead of /items). Uses a PagingAndSortingRepository as there could be a
 * lot of items and it would be costly and undesirable to show all the results
 * on one page. Users would also want to be able to sort items they are
 * searching for.
 * 
 * @author williamkorando
 *
 */
@RepositoryRestResource(collectionResourceRel = "merchandise", path = "merchandise")
public interface ItemRepo extends PagingAndSortingRepository<Item, Long> {
	/**
	 * Items should not be allowed to by deleted over the web.
	 */
	@RestResource(exported = false)
	void delete(Long aLong);

	@RestResource(exported = false)
	void delete(Item item);

	@RestResource(exported = false)
	void delete(Iterable<? extends Item> items);

	@RestResource(exported = false)
	void deleteAll(); 
	
	

	/**
	 * Only administrators should be able to create/make changes to an Item.
	 */
//	@PreAuthorize("hasRole('ADMIN')")
	<S extends Item> S save(S entity);

	@PreAuthorize("hasRole('ADMIN')")
	<S extends Item> Iterable<S> save(Iterable<S> entities);

	/**
	 * An example of allowing users to search within a resource by field.
	 * 
	 * Allow users to search for an item by its type.
	 * 
	 * @param type
	 * @return
	 */
	List<Item> findByType(@Param("type") String type);

	/**
	 * An example of allowing users to search for within a resource using a
	 * custom query and custom endpoint.
	 * 
	 * Allow users to search by the maximum price of an item.
	 * 
	 * @param maxPrice
	 * @return
	 */
	@RestResource(path = "byMaxPrice")
	@Query("SELECT i FROM Item i WHERE i.price <= :maxPrice")
	List<Item> findItemsLessThan(@Param("maxPrice") double maxPrice);

	/**
	 * An example of allowing users to search for within a resource using using
	 * multiple search criteria.
	 * 
	 * Allow users to search by the maximum price of an item and its type.
	 * 
	 * @param maxPrice
	 * @param type
	 * @return
	 */
	@RestResource(path = "byMaxPriceAndType")
	@Query("SELECT i FROM Item i WHERE i.price <= :maxPrice AND i.type = :type")
	List<Item> findItemsLessThanAndType(@Param("maxPrice") double maxPrice, @Param("type") String type);
}