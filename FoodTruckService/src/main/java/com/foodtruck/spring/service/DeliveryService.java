package com.foodtruck.spring.service;

import org.springframework.http.ResponseEntity;

import com.foodtruck.spring.model.Order;

public interface DeliveryService {

	ResponseEntity<String> placeFoodOrder(Order order);

}
