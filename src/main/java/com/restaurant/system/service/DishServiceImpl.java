package com.restaurant.system.service;

import com.restaurant.system.model.Dish;
import com.restaurant.system.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DishServiceImpl implements DishService {

    @Autowired
    private DishRepository dishRepository;

    @Override
    public List<Dish> allDishes() {
        return dishRepository.findAll();
    }

    @Override
    public void newPrice(int dishId, double price){
        Optional<Dish> optionalDish = dishRepository.findById(dishId);
        if(optionalDish.isPresent()){
            Dish dish = optionalDish.get();
            dish.setPrice(price);
            dishRepository.save(dish);
        }
        else{
            throw new RuntimeException("dish doesn't exist");
        }
    }

    @Override
    public void addDish(Dish dish){
        dishRepository.save(dish);
    }

    public Dish findDishById(int dishId) {
        return dishRepository.findById(dishId).orElse(null);
    }

    @Override
    public List<Dish> returnByCategory(String category) {
        return dishRepository.findByCategory(category);
    }

}
