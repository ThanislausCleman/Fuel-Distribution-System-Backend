package com.example.dispatch.listener;

import com.example.dispatch.model.Dispatch;
import com.example.dispatch.service.DispatchService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class KafkaListeners {

    DispatchService dispatchService;

    @KafkaListener(topics = "scheduleDispatchTopic", groupId = "TestGroup")
    public void consumeJson(@Payload List<Dispatch> data){

        String value = String.valueOf(data);
        int orderId = 0;
        String date = "";

        ObjectMapper objectMapper = new ObjectMapper();
        try {

            List<Dispatch> allocatedOrders = objectMapper.readValue(value, new TypeReference<List<Dispatch>>(){});
            for(Dispatch orderModel : allocatedOrders) {
                orderId  = orderModel.getOrderId();
                date = orderModel.getDate();
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        System.out.println(dispatchService.dispatchDelivery(orderId, date));

    }
}
