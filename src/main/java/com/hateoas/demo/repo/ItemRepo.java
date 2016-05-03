package com.hateoas.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import com.hateoas.demo.model.entity.Item;

public interface ItemRepo extends CrudRepository<Item, Long> {
	List<Item> findByType(@Param("type") String type);

	@RestResource(path = "byMaxPrice")
	@Query("SELECT i FROM Item i WHERE i.price <= :maxPrice")
	List<Item> findItemsLessThan(@Param("maxPrice") double maxPrice);

	@RestResource(path = "byMaxPriceAndType")
	@Query("SELECT i FROM Item i WHERE i.price <= :maxPrice AND i.type = :type")
	List<Item> findItemsLessThanAndType(@Param("maxPrice") double maxPrice, @Param("type") String type);
}
