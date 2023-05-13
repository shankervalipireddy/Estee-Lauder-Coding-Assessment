package com.foodtruck.spring.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.foodtruck.spring.service.DeliveryService;
import com.foodtruck.spring.model.Order;

@Service
public class DeliveryServiceImpl implements DeliveryService {

   

	@Override
	public ResponseEntity<String> placeFoodOrder(Order order) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
