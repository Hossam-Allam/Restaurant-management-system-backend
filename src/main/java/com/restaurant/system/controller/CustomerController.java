package com.restaurant.system.controller;

import com.restaurant.system.model.Customer;
import com.restaurant.system.model.LoginResponse;
import com.restaurant.system.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/signup")
    public String add(@RequestBody Customer customer){
        customerService.saveCustomer(customer);
        return "new customer added";
    }

    @GetMapping("/get")
    public List<Customer> getAllCustomers()
    {
        return customerService.getAllCustomers();
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody Map<String, String> loginRequest) {
        String username = loginRequest.get("username");
        String password = loginRequest.get("password");
        return customerService.authenticateCustomer(username, password);
    }

    @PutMapping("/newaddress")
    public String updateAddress(@RequestParam int id,@RequestParam String address ){
        customerService.newAddress(id, address);
        return "address updated";
    }

    @PutMapping("/newnumber")
    public String updatePhone(@RequestParam int id, @RequestParam long phoneno){
        customerService.newNumber(id, phoneno);
        return "number updated";
    }

    @PutMapping("/newpass")
    public String updatePassword(@RequestParam int id, @RequestParam String password){
        customerService.newPassword(id, password);
        return "password updated";
    }

}
