package com.hateoas.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

import com.hateoas.demo.model.validator.ItemValidator;

/**
 * Not being used here, but {@link RepositoryRestConfigurerAdapter} can be used
 * to customize the behavior of Spring-Data-REST.
 * 
 * @author williamkorando
 *
 */
@Configuration
public class RestConfiguration extends RepositoryRestConfigurerAdapter {

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.setBasePath("api");
	}
	
	/**
	 * Registering the {@link ItemValidator}.
	 */
	@Override
	public void configureValidatingRepositoryEventListener(ValidatingRepositoryEventListener v) {
	  v.addValidator("beforeCreate", new ItemValidator());
	}
}