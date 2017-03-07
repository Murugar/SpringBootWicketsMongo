package com.iqmsoft.boot.wickets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.iqmsoft.boot.wickets.model.Admin;
import com.iqmsoft.boot.wickets.repos.AdminRepository;



@EnableAutoConfiguration
@Configuration
@EnableMongoRepositories
@SpringBootApplication
@ComponentScan
public class WicketApplication extends SpringBootServletInitializer implements 
  CommandLineRunner{
	
	@Autowired
	private AdminRepository arepos;

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(WicketApplication.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(WicketApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		
		if(arepos.findAll().isEmpty())
		{
			arepos.save(new Admin("admin", "admin"));
			arepos.save(new Admin("user", "user"));
		}
		
	}
}
