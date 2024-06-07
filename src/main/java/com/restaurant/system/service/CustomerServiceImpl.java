package com.restaurant.system.service;

import com.restaurant.system.model.Customer;
import com.restaurant.system.model.LoginResponse;
import com.restaurant.system.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public LoginResponse authenticateCustomer(String username, String password) {
        Customer customer = customerRepository.findByUsername(username);
        if (customer != null && customer.getPassword().equals(password)) {
            return new LoginResponse(true, customer.getId(), username, customer.getAddress(), customer.getPhoneno());
        }
        return new LoginResponse(false, null);
    }

    @Override
    public void newAddress(int id, String address){
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if(optionalCustomer.isPresent()){
            Customer customer = optionalCustomer.get();
            customer.setAddress(address);
            customerRepository.save(customer);
        }
        else {
            throw new RuntimeException("invalid operation");
        }
    }

    @Override
    public void newNumber(int id, long phoneno){
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if(optionalCustomer.isPresent()){
            Customer customer = optionalCustomer.get();
            customer.setPhoneno(phoneno);
            customerRepository.save(customer);
        }
        else{
            throw new RuntimeException("invalid operation");
        }
    }

    @Override
    public void newPassword(int id, String password){
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if(optionalCustomer.isPresent()){
            Customer customer = optionalCustomer.get();
            customer.setPassword(password);
            customerRepository.save(customer);
        }
        else{
            throw new RuntimeException("something went wrong");
        }
    }
}
