package com.foodtruck.spring.service;

import com.foodtruck.spring.model.Review;

public interface ReviewService {

	void respondToReview(Long reviewId, String response);

	void submitReview(Review review);
}
