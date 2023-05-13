package com.foodtruck.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.foodtruck"})
public class FoodTruckWebsiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodTruckWebsiteApplication.class, args);
	}

}
