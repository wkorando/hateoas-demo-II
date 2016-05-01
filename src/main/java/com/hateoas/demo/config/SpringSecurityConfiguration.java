package com.hateoas.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Simple implementation of Spring-Security, used to demonstrate how access to
 * endpoints and HttpMethods can be limited by who the user is.
 * 
 * @author williamkorando
 *
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Override
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN")//
				.and().withUser("user").password("password").roles("USER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
				.antMatcher("/merchandise").authorizeRequests().antMatchers(HttpMethod.POST).hasAnyRole("ADMIN")//
				.and().antMatcher("/merchandise").authorizeRequests().antMatchers(HttpMethod.PUT).hasAnyRole("ADMIN")//
				.and().antMatcher("/**").authorizeRequests().antMatchers(HttpMethod.DELETE).denyAll()//
				.and().antMatcher("/merchandise").authorizeRequests().antMatchers(HttpMethod.GET).permitAll()//
				.and().antMatcher("/**").authorizeRequests().anyRequest().authenticated()
				.and().httpBasic();
	}
}