package com.restaurant.system.service;

import com.restaurant.system.model.Dish;

import java.util.List;

public interface DishService {

    public List<Dish> allDishes();

    public void newPrice(int dishId, double price);
}
