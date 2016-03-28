package com.hateoas.demo.repo;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hateoas.demo.HateoasDemoApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = HateoasDemoApplication.class)
public class TestItemRepo {
	@Autowired
	private ItemRepo itemRepo;
	
	@Test
	public void contextLoads() {
		assertThat(itemRepo.count()).isEqualTo(23);
	}
}
