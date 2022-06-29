package com.giantlink.glintranet;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.giantlink.glintranet.entities.Employee;
import com.giantlink.glintranet.requests.EmployeeRequest;
import com.giantlink.glintranet.services.EmployeeService;

@SpringBootApplication
@ComponentScan(basePackages = { "com.giantlink.*" })
@EntityScan(basePackages = { "com.giantlink.*" })
@EnableJpaRepositories(basePackages = { "com.giantlink.*" })

public class GlintranetApplication {
	
	

	public static void main(String[] args) {
		SpringApplication.run(GlintranetApplication.class, args);
	}
	
//	@Override
//	public void run(String... args) throws Exception {
//		EmployeeRequest build = EmployeeRequest.builder().firstName("mourad")
//				.lastName(" EL BACHIRI")
//				.CIN("zaaaa")
//				.username("user1")
//				.email("mourad.bch20@gmail.com")
//				.password("12345678900")
//				.phoneNumber("12345678900")
//				.birthDate("08-08-1997")
//				.build();
//		
//		EmployeeRequest build2 = EmployeeRequest.builder().firstName("bakr")
//				.lastName(" mhamdi")
//				.CIN("dfggf")
//				.username("user2")
//				.email("bakr.20@gmail.com")
//				.password("123456789")
//				.phoneNumber("12345678900")
//				.birthDate("08-08-2004")
//				.build();
//		
//		
//		employeeService.purge();
//		employeeService.add(build);
//		employeeService.add(build2);
//	}

	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
		
	}
	
	@Bean
	public SpringApplicationContext springApplicationContext() {
		return new SpringApplicationContext();
	}

}
