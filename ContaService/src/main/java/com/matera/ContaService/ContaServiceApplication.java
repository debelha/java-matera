package com.matera.ContaService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ContaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContaServiceApplication.class, args);
	}

}
