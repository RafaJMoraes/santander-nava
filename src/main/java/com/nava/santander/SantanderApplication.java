package com.nava.santander;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SantanderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SantanderApplication.class, args);
	}

}
