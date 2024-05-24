package com.restaurant.system.repository;

import com.restaurant.system.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Customer findByUsername(String username);
}
