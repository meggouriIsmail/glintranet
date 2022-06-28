package com.giantlink.glintranet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = { "com.giantlink.*" })
@EntityScan(basePackages = { "com.giantlink.*" })
@EnableJpaRepositories(basePackages = { "com.giantlink.*" })

public class GlintranetApplication {

	public static void main(String[] args) {
		SpringApplication.run(GlintranetApplication.class, args);
	}

}
