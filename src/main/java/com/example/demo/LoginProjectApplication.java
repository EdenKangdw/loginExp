package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class LoginProjectApplication {

	public static void main(String[] args) {
		final String Propeties = "spring.config.location=classpath:/google.yml";
		new SpringApplicationBuilder(LoginProjectApplication.class)
		.properties(Propeties)
		.run(args);
	}

}
