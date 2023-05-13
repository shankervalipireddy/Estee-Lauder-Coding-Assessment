package com.foodtruck.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.foodtruck.spring.model.Customer;
import com.foodtruck.spring.model.FoodTruck;
import com.foodtruck.spring.model.Order;
import com.foodtruck.spring.model.Review;
import com.foodtruck.spring.model.SocialMediaPost;
import com.foodtruck.spring.service.DeliveryService;
import com.foodtruck.spring.service.FoodTruckService;
import com.foodtruck.spring.service.LoyaltyProgramService;
import com.foodtruck.spring.service.ReviewService;
import com.foodtruck.spring.service.SocialMediaService;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class FoodTruckController {

	@Autowired
	private FoodTruckService foodTruckService;

	@Autowired
	private SocialMediaService socialMediaService;

	@Autowired
	private LoyaltyProgramService loyaltyProgramService;

	@Autowired
	private ReviewService reviewService;

	@Autowired
	private DeliveryService deliveryService;

	// Endpoint to list all trucks
	@GetMapping("/foodtrucks")
	@CrossOrigin
	public List<FoodTruck> getFoodTrucks() throws IOException, CsvException {
		return foodTruckService.getAllFoodTrucks();
	}

	// Endpoint to find near by truck
	@GetMapping("/foodtrucks/nearby")
	@CrossOrigin
	public List<FoodTruck> getNearbyFoodTrucks(@RequestParam double latitude, @RequestParam double longitude,
			@RequestParam(defaultValue = "120") double radius) throws IOException, CsvException {
		// Implement logic to filter and return nearby food trucks based on latitude,
		// longitude, and radius
		return foodTruckService.getFoodTrucksNearby(latitude, longitude, radius);

	}

	// Endpoint to post content on social media platforms
	@PostMapping("/social-media")
	public ResponseEntity<String> postOnSocialMedia(@RequestBody SocialMediaPost post) {
		socialMediaService.postContent(post);
		return ResponseEntity.ok("Content posted on social media.");
	}

	// Endpoint to handle registering a customer for the loyalty program
	@PostMapping("/loyalty/register")
	public ResponseEntity<String> registerForLoyaltyProgram(@RequestBody Customer customer) {
		loyaltyProgramService.registerCustomer(customer);
		return ResponseEntity.ok("Customer registered for the loyalty program.");
	}

	// Endpoint to handle submitting a review
	@PostMapping("/reviews")
	public ResponseEntity<String> submitReview(@RequestBody Review review) {
		reviewService.submitReview(review);
		return ResponseEntity.ok("Review submitted successfully.");
	}

	// Endpoint to handle responding to a review
	@PostMapping("/reviews/{reviewId}/response")
	public ResponseEntity<String> respondToReview(@PathVariable("reviewId") Long reviewId,
			@RequestBody String response) {
		reviewService.respondToReview(reviewId, response);
		return ResponseEntity.ok("Review response added.");
	}

	// Endpoint to handle online food ordering
	@PostMapping("/order")
	public ResponseEntity<String> placeFoodOrder(@RequestBody Order order) {
		deliveryService.placeFoodOrder(order);
		return ResponseEntity.ok("Order placed successfully.");
	}

}
