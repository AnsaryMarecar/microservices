package com.catastima.home;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.catastima.home")
public class CatastimaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatastimaApplication.class, args);
	}

}
