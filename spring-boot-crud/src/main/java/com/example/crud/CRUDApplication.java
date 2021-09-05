package com.example.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.crud"})
public class CRUDApplication {

	public static void main(String[] args) {
		SpringApplication.run(CRUDApplication.class, args);
	}

}
