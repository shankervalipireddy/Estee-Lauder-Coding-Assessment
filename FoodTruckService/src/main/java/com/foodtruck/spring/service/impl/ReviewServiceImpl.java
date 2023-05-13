package com.foodtruck.spring.service.impl;

import org.springframework.stereotype.Service;

import com.foodtruck.spring.model.Review;
import com.foodtruck.spring.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService{

	// Encourage customers to leave positive reviews and handle negative reviews
	// professionally.
	@Override
	public void submitReview(Review review) {
		
		//TODO


	}

	// Respond promptly and professionally to both positive and negative reviews.
	public void respondToReview(Long reviewId, String response) {
		//ToDO
		
	}

	

}
