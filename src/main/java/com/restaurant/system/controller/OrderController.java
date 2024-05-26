package com.restaurant.system.controller;

import com.restaurant.system.model.Order;
import com.restaurant.system.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;


    @PostMapping("/neworder")
    public String addOrder(@RequestBody Order order){
        orderService.saveOrder(order);
        return "order placed";
    }

    @GetMapping("/get")
    public List<Order> allOrders(){
        return orderService.getOrders();
    }
}
