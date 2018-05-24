package org.climb.consumer.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/**
 * Abstract class to get the DataSource so we can communicate with the DB
 * @author bill
 * @see https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-sql.html
 */
public class AbstractDaoImpl {

	@Autowired
	@Qualifier("dataSourceClimb")
	private DataSource dataSource;
	protected NamedParameterJdbcTemplate npjTemplate;
	
	protected DataSource getDataSource() {
		return dataSource;
	}
	
	protected void setDataSource(DataSource jdbc) {
		this.npjTemplate = new NamedParameterJdbcTemplate(jdbc);
	}
}
