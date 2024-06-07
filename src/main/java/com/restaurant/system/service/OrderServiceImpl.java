package com.restaurant.system.service;

import com.restaurant.system.model.Customer;
import com.restaurant.system.model.Dish;
import com.restaurant.system.model.Order;
import com.restaurant.system.repository.CustomerRepository;
import com.restaurant.system.repository.DishRepository;
import com.restaurant.system.repository.OrderRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private DishRepository dishRepository;

    @Override
    public Order saveOrder(Order order) {
        // Fetch and set the customer
        Customer customer = customerRepository.findById(order.getCustomer().getId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        order.setCustomer(customer);

        // Initialize dishes if null
        if (order.getDishes() == null) {
            order.setDishes(new HashSet<>());
        }

        // Fetch and set the dishes
        Set<Dish> dishes = order.getDishes().stream()
                .map(dish -> dishRepository.findById(dish.getDishId())
                        .orElseThrow(() -> new RuntimeException("Dish not found: " + dish.getDishId())))
                .collect(Collectors.toSet());
        order.setDishes(dishes);

        return orderRepository.save(order);
    }

    @Override
    public List<Order> getOrders(){
        return orderRepository.findAll();
    }

    @Override
    public void paid(int orderId){
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        if(optionalOrder.isPresent()){
            Order order = optionalOrder.get();
            order.setPaid(true);
            orderRepository.save(order);
        }
        else{
            throw new RuntimeException("invalid id");
        }
    }

    @Override
    public void ready(int orderId){
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        if(optionalOrder.isPresent()){
            Order order = optionalOrder.get();
            order.setReady(true);
            orderRepository.save(order);
        }
        else{
            throw new RuntimeException("arsenal pl 2025 champions");
        }
    }

    @Override
    public void delivered(int orderId){
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        if(optionalOrder.isPresent()){
            Order order = optionalOrder.get();
            order.setDelivered(true);
            orderRepository.save(order);
        }
        else{
            throw new RuntimeException("invalid id");
        }
    }
}
