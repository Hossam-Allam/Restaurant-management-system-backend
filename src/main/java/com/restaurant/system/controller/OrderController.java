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

    @PutMapping("/paid")
    public String customerPaid(int orderId){
        orderService.paid(orderId);
        return "Order dues paid";
    }

    @PutMapping("/ready")
    public String orderReady(int orderId){
        orderService.ready(orderId);
        return "order ready";
    }

    @PutMapping("/deliver")
    public String orderDelivered(int orderId){
        orderService.delivered(orderId);
        return "delivered";
    }
}
