# Estee-Lauder-Coding-Assessment
Estee Lauder-Coding Assessment

#Food Truck Web App
The Food Truck Web App is a web application built with React.js that allows users to view food trucks, post content on social media platforms, register for a loyalty program, submit reviews, respond to reviews, and place online food orders.

#Features
List all food trucks
Find nearby food trucks based on location
Post content on social media platforms
Register for a loyalty program
Submit reviews for food trucks
Respond to reviews
Place online food orders
Installation
To run the Food Truck Web App locally on your machine, follow these steps:

#Clone the repository:

git clone git clone https://github.com/shankervalipireddy/Estee-Lauder-Coding-Assessment.git


Navigate to the project directory:

cd food-truck-web-app

npm install

npm start


Open your browser and visit http://localhost:3000 to access the web app.

#API Endpoints
The web app communicates with a backend API to fetch and post data. Here are the API endpoints used:

GET /foodtrucks: Retrieve a list of all food trucks.
GET /foodtrucks/nearby: Find nearby food trucks based on location.
POST /social-media: Post content on social media platforms.
POST /loyalty/register: Register for the loyalty program.
POST /reviews: Submit reviews for food trucks.
POST /reviews/{reviewId}/response: Respond to reviews.
POST /order: Place online food orders.

To access the end points above:

Import FoodTruckService Spring boot project into Eclipse/STS/IntelliJ IDE
Start the Spring Boot project from Elcpise

FoodTruckService
FoodTruckService is a RESTful API that provides information about food trucks. It allows users to retrieve information about food trucks based on various criteria.

Features
Retrieve a list of all food trucks
Retrieve a list of food trucks by location
Retrieve a list of food trucks by cuisine type
Retrieve a list of food trucks by rating
Add a new food truck
Update an existing food truck
Delete a food truck

#Backend Technologies Used
Java
Spring Boot
Gradle for dependency management
RESTful API architecture
JSON for data exchange

Getting Started
To get started with the FoodTruckService project, follow these steps:

Clone the repository and Build the project using Gradle Refresh and Run the application.

The application will start running on http://localhost:8080

Test the endpoints:
GET /foodtrucks: Retrieve a list of all food trucks.
GET /foodtrucks/nearby: Find nearby food trucks based on location.
POST /social-media: Post content on social media platforms.
POST /loyalty/register: Register for the loyalty program.
POST /reviews: Submit reviews for food trucks.
POST /reviews/{reviewId}/response: Respond to reviews.
POST /order: Place online food orders.


#Front end Technologies Used
React.js
Axios (HTTP client library)
Bootstrap (CSS framework)
Spring Boot
Java Script
HTML
CSS



