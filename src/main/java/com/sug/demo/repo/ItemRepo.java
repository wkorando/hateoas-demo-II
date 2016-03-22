package com.sug.demo.repo;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.sug.demo.model.entity.Item;

@RepositoryRestResource(collectionResourceRel = "items", path = "items")
public interface ItemRepo extends PagingAndSortingRepository<Item, Long> {

	public List<Item> findByType(String type);
}
