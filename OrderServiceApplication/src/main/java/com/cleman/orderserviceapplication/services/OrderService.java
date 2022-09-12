package com.cleman.orderserviceapplication.services;

import com.cleman.orderserviceapplication.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    Order createOrder(Order order);

    List<Order> getAllOrders();

    List<Order> findByOrderId(String orderId);

}
