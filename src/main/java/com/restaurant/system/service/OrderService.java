package com.restaurant.system.service;

import com.restaurant.system.model.Order;
import org.aspectj.weaver.ast.Or;

import java.util.List;

public interface OrderService {

    public Order saveOrder(Order order);

    public List<Order> getOrders();
}
