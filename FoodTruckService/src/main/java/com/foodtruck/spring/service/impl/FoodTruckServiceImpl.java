package com.foodtruck.spring.service.impl;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.foodtruck.spring.model.FoodTruck;
import com.foodtruck.spring.service.FoodTruckService;

@Service
public class FoodTruckServiceImpl implements FoodTruckService {
	private List<FoodTruck> foodTrucks;
	private static final String DATA_FILE_PATH = "/food_trucks.csv";

	

	@Value("${csv.file.path}")
    private String csvFilePath;

	public List<FoodTruck> getAllFoodTrucks() throws IOException {
		List<FoodTruck> foodTrucks = new ArrayList<>();

		FileReader reader = new FileReader(csvFilePath);
		CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader());

		for (CSVRecord record : csvParser) {
			int locationId = Integer.parseInt(record.get("locationid"));
			String applicant = record.get("Applicant");
			String facilityType = record.get("FacilityType");
			int cnn = parseInteger(record.get("cnn"));
			String locationDescription = record.get("LocationDescription");
			String address = record.get("Address");
			String blockLot = record.get("blocklot");
			String block = record.get("block");
			String lot = record.get("lot");
			String permit = record.get("permit");
			String status = record.get("Status");
			String foodItems = record.get("FoodItems");
			double x = parseDouble(record.get("X"));
			double y = parseDouble(record.get("Y"));
			double latitude = Double.parseDouble(record.get("Latitude"));
			double longitude = Double.parseDouble(record.get("Longitude"));
			String schedule = record.get("Schedule");
			String daysHours = record.get("dayshours");
			String noiSent = record.get("NOISent");
			String approved = record.get("Approved");
			String received = record.get("Received");
			String priorPermit = record.get("PriorPermit");
			String expirationDate = record.get("ExpirationDate");
			String location = record.get("Location");

			// Create FoodTruck object and add it to the list
			FoodTruck foodTruck = new FoodTruck();
			foodTruck.setLocationId(locationId);
			foodTruck.setApplicant(applicant);
			foodTruck.setFacilityType(facilityType);
			foodTruck.setCnn(cnn);
			foodTruck.setLocationDescription(locationDescription);
			foodTruck.setAddress(address);
			foodTruck.setBlockLot(blockLot);
			foodTruck.setBlock(block);
			foodTruck.setLot(lot);
			foodTruck.setPermit(permit);
			foodTruck.setStatus(status);
			foodTruck.setFoodItems(foodItems);
			foodTruck.setX(x);
			foodTruck.setY(y);
			foodTruck.setLatitude(latitude);
			foodTruck.setLongitude(longitude);
			foodTruck.setSchedule(schedule);
			foodTruck.setDaysHours(daysHours);
			foodTruck.setNoiSent(noiSent);
			foodTruck.setApproved(approved);
			foodTruck.setReceived(received);
			foodTruck.setPriorPermit(priorPermit);
			foodTruck.setExpirationDate(expirationDate);
			foodTruck.setLocation(location);

			foodTrucks.add(foodTruck);
		}

		csvParser.close();
		return foodTrucks;
	}

	private int parseInteger(String value) {
		try {
			return Integer.parseInt(value);
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	private double parseDouble(String value) {
		try {
			return Double.parseDouble(value);
		} catch (NumberFormatException e) {
			return 0.0;
		}
	}

	@Override
	public FoodTruck getFoodTruckById(int id) {
		// Find and return the food truck with the specified ID
		for (FoodTruck foodTruck : foodTrucks) {
			if (foodTruck.getLocationId() == id) {
				return foodTruck;
			}
		}
		return null; // Return null if no food truck with the specified ID is found
	}

	@Override
	public List<FoodTruck> getFoodTrucksByLocation(String location) throws IOException {
		// Find and return the food trucks with the specified location
		List<FoodTruck> matchingFoodTrucks = new ArrayList<>();
		for (FoodTruck foodTruck : getAllFoodTrucks()) {
			if (foodTruck.getLocation().equalsIgnoreCase(location)) {
				matchingFoodTrucks.add(foodTruck);
			}
		}
		return matchingFoodTrucks;
	}

	@Override
	public List<FoodTruck> getFoodTrucksByType(String facilityType) throws IOException {
		// Find and return the food trucks with the specified facility type
		List<FoodTruck> matchingFoodTrucks = new ArrayList<>();
		for (FoodTruck foodTruck : getAllFoodTrucks()) {
			if (foodTruck.getFacilityType().equalsIgnoreCase(facilityType)) {
				matchingFoodTrucks.add(foodTruck);
			}
		}
		return matchingFoodTrucks;
	}

	@Override
	public List<FoodTruck> getFoodTrucksByFoodItem(String foodItem) throws IOException {
		// Find and return the food trucks that serve the specified food item
		List<FoodTruck> matchingFoodTrucks = new ArrayList<>();
		for (FoodTruck foodTruck : getAllFoodTrucks()) {
			if (foodTruck.getFoodItems().toLowerCase().contains(foodItem.toLowerCase())) {
				matchingFoodTrucks.add(foodTruck);
			}
		}
		return matchingFoodTrucks;
	}

	@Override
	public List<FoodTruck> getFoodTrucksNearby(double latitude, double longitude, double distance) throws IOException {
		// Find and return the food trucks located within the specified distance from
		// the given coordinates
		List<FoodTruck> nearbyFoodTrucks = new ArrayList<>();
		for (FoodTruck foodTruck : getAllFoodTrucks()) {
			double truckDistance = calculateDistance(latitude, longitude, foodTruck.getLatitude(),
					foodTruck.getLongitude());
			if (truckDistance <= distance) {
				nearbyFoodTrucks.add(foodTruck);
			}
		}
		return nearbyFoodTrucks;
	}

	public static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
		// Calculate the distance between two latitude-longitude points using the
		// Haversine formula
		double earthRadius = 6371; // Radius of the Earth in kilometers

		// Convert latitude and longitude to radians
		double lat1Rad = Math.toRadians(lat1);
		double lon1Rad = Math.toRadians(lon1);
		double lat2Rad = Math.toRadians(lat2);
		double lon2Rad = Math.toRadians(lon2);

		// Calculate the differences between coordinates
		double dLat = lat2Rad - lat1Rad;
		double dLon = lon2Rad - lon1Rad;

		// Apply the Haversine formula
		double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
				+ Math.cos(lat1Rad) * Math.cos(lat2Rad) * Math.sin(dLon / 2) * Math.sin(dLon / 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		double distance = earthRadius * c;

		return distance;
	}

	@Override
	public void addFoodTruck(FoodTruck foodTruck) {
		// Add a new food truck to the list
		foodTrucks.add(foodTruck);
	}

	@Override
	public void deleteFoodTruck(int id) {
		// TODO 

	}

	@Override
	public void updateFoodTruck(FoodTruck foodTruck) {
		// TODO 

	}

}