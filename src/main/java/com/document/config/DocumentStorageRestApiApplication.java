package com.document.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@CrossOrigin
@SpringBootApplication
@Configuration
@ComponentScan("com.document.*")
@PropertySource("classpath:application.properties")
@EnableAutoConfiguration
@EnableJpaRepositories("com.document.*")
@EntityScan("com.document.*")
@EnableTransactionManagement
public class DocumentStorageRestApiApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(DocumentStorageRestApiApplication.class, args);
	}
	
	@Override
	 protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	  return application.sources(DocumentStorageRestApiApplication.class);
	 }
	
	@RequestMapping("/")
    String defaultMapping()
    {
        return "You are into Document Storage API, use appropriate path to access the API.";
    }
}
