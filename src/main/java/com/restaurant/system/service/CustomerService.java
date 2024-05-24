package com.restaurant.system.service;

import com.restaurant.system.model.Customer;
import com.restaurant.system.model.LoginResponse;

import java.util.List;

public interface CustomerService {

    public Customer saveCustomer(Customer customer);

    public List<Customer> getAllCustomers();

    public LoginResponse authenticateCustomer(String username, String password);

    public void newAddress(int id, String address);

    public void newNumber(int id, long phoneno);
}

