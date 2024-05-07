package com.rodrigues.silva.marcos.hrpayrool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class HrpayroolApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrpayroolApplication.class, args);
	}

}
