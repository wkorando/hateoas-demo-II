package com.hateoas.demo.config;

import java.io.IOException;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Wire up JPA using Hibernate.
 * 
 * @author williamkorando
 *
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.hateoas.demo.repo")
@PropertySource("hibernate.properties")
public class HibernateConfiguration {

	@Bean
	public DataSource dataSource() {
		EmbeddedDatabaseBuilder databaseBuilder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase database = databaseBuilder.setType(EmbeddedDatabaseType.H2).build();
		return database;
	}

	@Bean
	public Properties hibernateProperties() throws IOException {
		PropertiesFactoryBean factoryBean = new PropertiesFactoryBean();
		factoryBean.setLocation(new ClassPathResource("hibernate.properties"));
		factoryBean.afterPropertiesSet();
		return factoryBean.getObject();
	}

	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		return transactionManager;
	}

	@Bean
	public EntityManagerFactory entityManagerFactory(DataSource dataSource, JpaVendorAdapter jpaVendorAdapter,
			Properties hibernateProperties) {
		LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
		entityManager.setDataSource(dataSource);
		entityManager.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		entityManager.setPackagesToScan("com.hateoas.demo.model.entity");
		entityManager.setJpaVendorAdapter(jpaVendorAdapter());
		entityManager.setJpaProperties(hibernateProperties);
		entityManager.afterPropertiesSet();
		return entityManager.getObject();
	}

	private JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		jpaVendorAdapter.setGenerateDdl(true);
		jpaVendorAdapter.setShowSql(true);
		jpaVendorAdapter.setDatabase(Database.H2);
		return jpaVendorAdapter;
	}
}
