package com.seleznov.reactive.spring.exmaples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class RelationDbExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(RelationDbExampleApplication.class, args);
	}
}
