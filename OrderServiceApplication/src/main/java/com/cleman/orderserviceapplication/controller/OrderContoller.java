package com.cleman.orderserviceapplication.controller;

import com.cleman.orderserviceapplication.model.Order;
import com.cleman.orderserviceapplication.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "/orderfuel")
public class OrderContoller {

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/createOrder", method = RequestMethod.POST)
    public Order createOrder(@RequestBody Order order){
        return orderService.createOrder(order);
    }

    @RequestMapping(value = "/getAllOrders", method = RequestMethod.GET)
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }


    @RequestMapping(value = "/viewById/{id}", method = RequestMethod.GET)
    public List<Order> findByOrderId(@PathVariable("id") String orderId){
        return orderService.findByOrderId(orderId);
    }

}
