package com.cleman.orderserviceapplication.services;


import com.cleman.orderserviceapplication.model.Order;
import com.cleman.orderserviceapplication.repository.OrderRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;




@Service
public class OrderServiceImpl implements OrderService {

    @Value("${order.topic.name}")
    String topicName;



    @Autowired
    OrderRepository orderRepository;

    @Autowired
    KafkaTemplate <String, String> kafkaTemplate;

    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Order createOrder(Order order) {
        order.setOrderStatus("order created");
        //order.setDispatchDate(null);
        order =  orderRepository.save(order);
        String orderStr = null;
        try {
            orderStr = objectMapper.writeValueAsString(order);

        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
        kafkaTemplate.send(topicName,orderStr);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>"+orderStr);
        System.out.println(order);
        return order;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> findByOrderId(String orderId) {
        return orderRepository.findByOrderId(orderId);
    }

}

