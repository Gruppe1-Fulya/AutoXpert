package com.example.deneme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DenemeApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(DenemeApplication.class, args);
	}

}
