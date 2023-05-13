package com.foodtruck.spring.service;

import com.foodtruck.spring.model.FoodTruck;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.util.List;

public interface FoodTruckService {
	List<FoodTruck> getAllFoodTrucks() throws IOException, CsvException;

	FoodTruck getFoodTruckById(int id);

	List<FoodTruck> getFoodTrucksByLocation(String location) throws IOException, CsvException;

	List<FoodTruck> getFoodTrucksByType(String facilityType) throws IOException, CsvException;

	List<FoodTruck> getFoodTrucksByFoodItem(String foodItem) throws IOException, CsvException;

	void addFoodTruck(FoodTruck foodTruck);

	void updateFoodTruck(FoodTruck foodTruck);

	void deleteFoodTruck(int id);

	List<FoodTruck> getFoodTrucksNearby(double latitude, double longitude, double radius) throws IOException, CsvException;

}
