package com.cleman.scheduleserviceapplication.service;


import com.cleman.scheduleserviceapplication.model.Order;
import com.cleman.scheduleserviceapplication.model.Schedule;
import com.cleman.scheduleserviceapplication.repository.OrderRepository;
import com.cleman.scheduleserviceapplication.repository.ScheduleRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Value("${schedule.topic.name}")
    String reserveTopicName;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ScheduleRepository scheduleRepository;

    @Autowired
    SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "schedules-topic",groupId = "groupId")
    public void processReserve(String message){
        System.out.println("Received Message : " + message);
        try {
            Order order = objectMapper.readValue(message, Order.class);
            //System.out.println(">>>>>>>>>>>>>>>>>>>>"+order.getOrderStatus());

            order.setOrderStatus("delivery scheduled");
            order.setDate(sequenceGeneratorService.generateLocalDate());
            order.setDispatchDate(null);
            orderRepository.save(order);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public List<Schedule> viewAll() {
        return scheduleRepository.findAll();
    }

    @Override
    public List<Schedule> findByOrderId(String orderId) {
        List<Schedule> schedules = new ArrayList<>();
        return scheduleRepository.findByOrderId(orderId);
    }
}

