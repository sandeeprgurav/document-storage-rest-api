package com.document.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

public class DataSourceConfig {
	
	@Autowired
	private Environment env;
	
	@Bean
	@ConfigurationProperties("spring.datasource")
	public DataSource dataSource() throws IOException {
		return DataSourceBuilder.create().url(env.getProperty("spring.datasource.url"))
				.driverClassName(env.getProperty("spring.datasource.driverClassName"))
				.username(env.getProperty("spring.datasource.username"))
				.password(env.getProperty("spring.datasource.password")).build();				
	}
}
