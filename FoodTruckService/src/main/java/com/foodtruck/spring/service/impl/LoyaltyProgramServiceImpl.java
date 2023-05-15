package com.foodtruck.spring.service.impl;

import org.springframework.stereotype.Service;
import com.foodtruck.spring.model.Customer;
import com.foodtruck.spring.service.LoyaltyProgramService;

@Service
public class LoyaltyProgramServiceImpl implements LoyaltyProgramService {

    private List<Customer> registeredCustomers;

    public LoyaltyProgramServiceImpl() {
        registeredCustomers = new ArrayList<>();
    }

    @Override
    public void registerCustomer(Customer customer) {
        registeredCustomers.add(customer);
    }
}
