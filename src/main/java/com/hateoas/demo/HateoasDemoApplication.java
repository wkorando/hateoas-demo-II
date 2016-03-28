package com.hateoas.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration;
import org.springframework.context.annotation.Import;

@SpringBootApplication
public class HateoasDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HateoasDemoApplication.class, args);
	}
}
