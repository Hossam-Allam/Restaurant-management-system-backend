package com.restaurant.system.controller;

import com.restaurant.system.model.Dish;
import com.restaurant.system.service.DishService;
import com.restaurant.system.service.DishServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dish")
@CrossOrigin
public class DishController {

    @Autowired
    private DishService dishService;

    @Autowired
    private DishServiceImpl dishServiceImpl;

    @GetMapping("/all")
    private List<Dish> allItems(){
        return dishService.allDishes();
    }

    @PutMapping("/price")
    private String priceUpdate(@RequestParam int dishId, @RequestParam double price) {

        Dish dish = dishServiceImpl.findDishById(dishId);
        if (dish != null) {
            dishService.newPrice(dishId, price);
            return "New price: " + price + " for: " + dish.getName();
        } else {
            return "Dish not found";
        }
    }
}
