package com.restaurant.system.repository;

import com.restaurant.system.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DishRepository extends JpaRepository<Dish, Integer> {
    List<Dish> findByCategory(String category);
}
