package org.climb.consumer.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Abstract class to get the DataSource so we can communicate with the DB
 * @author bill
 * @see https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-sql.html
 */
public class AbstractDaoImpl {

	private DataSource dataSource;
	
	@Autowired
	@Qualifier("dataSourceClimb")
	protected DataSource getDataSource() {
		return dataSource;
	}
}
