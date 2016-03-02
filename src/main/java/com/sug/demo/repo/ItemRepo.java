package com.sug.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sug.demo.model.entity.Item;

public interface ItemRepo extends JpaRepository<Item, Long> {

	public List<Item> findByType(String type);
}
