package com.tinqin.payments.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.tinqin.payments")
//@EntityScan(basePackages = "com.tinqin.payments.persistence.entity")
//@EnableJpaRepositories(basePackages = "com.tinqin.payments.persistence.repository")
@SpringBootApplication
public class TinqinPaymentsApplication {
	public static void main(String[] args) {
		SpringApplication.run(TinqinPaymentsApplication.class, args);
	}
}
