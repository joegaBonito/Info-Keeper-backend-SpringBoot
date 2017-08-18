package com.joe.infokeeperbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class InfoKeeperBackendApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(InfoKeeperBackendApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(InfoKeeperBackendApplication.class, args);
	}
}
