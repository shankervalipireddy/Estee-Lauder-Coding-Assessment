import React, { useEffect, useState } from "react";
import axios from "axios";
import { Table, Pagination  ,Form, Button} from "react-bootstrap";


function App() {
  const [foodTrucks, setFoodTrucks] = useState([]);
  const [currentPage, setCurrentPage] = useState(1);
  const [trucksPerPage] = useState(10);

  useEffect(() => {
    // Fetch food trucks from the backend API
    axios
      .get("http://localhost:8080/foodtrucks")
      .then((response) => {
        setFoodTrucks(response.data);
      })
      .catch((error) => {
        console.error("Error fetching food trucks:", error);
      });
  }, []);

  // Get current trucks based on pagination
  const indexOfLastTruck = currentPage * trucksPerPage;
  const indexOfFirstTruck = indexOfLastTruck - trucksPerPage;
  const currentTrucks = foodTrucks.slice(indexOfFirstTruck, indexOfLastTruck);

  // Change page
  const paginate = (pageNumber) => setCurrentPage(pageNumber);

 // Function to handle nearby food trucks endpoint
  const getNearbyFoodTrucks = () => {
   //TODO
  };

  // Function to handle posting on social media endpoint
  const postOnSocialMedia = (post) => {
   //TODO
  };

  // Function to handle registering for loyalty program endpoint
  const registerForLoyaltyProgram = (customer) => {
  //TODO
  };

  // Function to handle submitting a review endpoint
  const submitReview = (review) => {
   //TODO
  };

  // Function to handle responding to a review endpoint
  const respondToReview = (reviewId, response) => {
   //TODO
    };
  return (
    <div>
      <h1>Food Truck Web App</h1>
      <h2>Food Truck List in San Fransisco:</h2>
      <Table striped bordered hover>
        <thead>
          <tr>
            <th>Name</th>
            <th>Cuisine</th>
            <th>Location</th>
          </tr>
        </thead>
        <tbody>
          {currentTrucks.map((foodTruck) => (
            <tr key={foodTruck.locationid}>
              <td>{foodTruck.applicant}</td>
              <td>{foodTruck.foodItems}</td>
              <td>{foodTruck.locationDescription}</td>
            </tr>
          ))}
        </tbody>
      </Table>
      <Pagination>
        <Pagination.Prev
          onClick={() => paginate(currentPage - 1)}
          disabled={currentPage === 1}
        />
        {Array.from({ length: Math.ceil(foodTrucks.length / trucksPerPage) }).map(
          (_, index) => (
            <Pagination.Item
              key={index}
              active={index + 1 === currentPage}
              onClick={() => paginate(index + 1)}
            >
              {index + 1}
            </Pagination.Item>
          )
        )}
        <Pagination.Next
          onClick={() => paginate(currentPage + 1)}
          disabled={currentPage === Math.ceil(foodTrucks.length / trucksPerPage)}
        />
      </Pagination>
      
       <Form onSubmit={getNearbyFoodTrucks}>
          <Form.Group>
            <Form.Label>Latitude</Form.Label>
            <Form.Control type="text" />
          </Form.Group>
          <Form.Group>
            <Form.Label>Longitude</Form.Label>
            <Form.Control type="text" />
          </Form.Group>
          <Form.Group>
            <Form.Label>Radius</Form.Label>
            <Form.Control type="text" />
          </Form.Group>
          <Button variant="primary" type="submit">
            Get Nearby Food Trucks
          </Button>
        </Form>
        <Form onSubmit={postOnSocialMedia}>
          <Form.Group>
            <Form.Label>Content</Form.Label>
            <Form.Control as="textarea" rows={3} />
          </Form.Group>
          <Button variant="primary" type="submit">
            Post on Social Media
          </Button>
        </Form>
        <Form onSubmit={registerForLoyaltyProgram}>
          <Form.Group>
            <Form.Label>Name</Form.Label>
            <Form.Control type="text" />
          </Form.Group>
          <Form.Group>
            <Form.Label>Email</Form.Label>
            <Form.Control type="email" />
          </Form.Group>
          <Button variant="primary" type="submit">
            Register for Loyalty Program
          </Button>
        </Form>
        <Form onSubmit={submitReview}>
          <Form.Group>
            <Form.Label>Food Truck ID</Form.Label>
            <Form.Control type="text" />
          </Form.Group>
          <Form.Group>
            <Form.Label>Rating</Form.Label>
            <Form.Control type="number" />
          </Form.Group>
          <Form.Group>
            <Form.Label>Comment</Form.Label>
            <Form.Control as="textarea" rows={3} />
          </Form.Group>
          <Button variant="primary" type="submit">
            Submit Review
          </Button>
        </Form>
       
    </div>
    
    
  );
}

export default App;