package org.cbioportal.persistence.clickhouse;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.apache.commons.dbcp2.BasicDataSource;

@Profile("clickhouse")
@Configuration
@ConfigurationProperties(prefix = "db.clickhouse")
@MapperScan(value = "org.cbioportal.persistence.clickhouse.mapper", annotationClass = ClickHouseConnMapper.class, sqlSessionFactoryRef = "ClickHouseSessionFactory")
public class ClickHouseConfig {

	private String driverClassName;
	private String connectionString;
	private String username;
	private String password;

	@Bean(name = "ClickHouseDataSource")
	public DataSource dataSource() {
		BasicDataSource bds = new BasicDataSource();
		bds.setDriverClassName(this.driverClassName);
		bds.setUsername(this.username);
		bds.setPassword(this.password);
		bds.setUrl(this.connectionString);
		
		
		return bds;

	}

	@Bean(name = "ClickHouseSessionFactory")
	public SqlSessionFactory clickhouseSessionFactory() throws Exception {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(dataSource());
		return factoryBean.getObject();
	}

	@Bean(name = "ClickHouseSessionTemplate")
	public SqlSessionTemplate clickhouseSessionTemplate(
			@Qualifier("ClickHouseSessionFactory") SqlSessionFactory clickhouseSessionFactory) {

		return new SqlSessionTemplate(clickhouseSessionFactory);
	}

	@Bean(name = "ClickHouseTransactionManager")
	public DataSourceTransactionManager PrimaryTransactionManager(
			@Qualifier("ClickHouseDataSource") DataSource clickhouseDataSource) {

		return new DataSourceTransactionManager(clickhouseDataSource);
	}

	public String getDriverClassName() {
		return driverClassName;
	}

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}

	public String getConnectionString() {
		return connectionString;
	}

	public void setConnectionString(String connectionString) {
		this.connectionString = connectionString;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
