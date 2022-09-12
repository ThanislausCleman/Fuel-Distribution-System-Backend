package com.cleman.inventoryserviceapplication.service;


import com.cleman.inventoryserviceapplication.model.AvailableFuel;
import com.cleman.inventoryserviceapplication.model.Order;
import com.cleman.inventoryserviceapplication.model.ReservedFuel;
import com.cleman.inventoryserviceapplication.repository.AvailableFuelRepository;
import com.cleman.inventoryserviceapplication.repository.OrderRepository;
import com.cleman.inventoryserviceapplication.repository.ReservedFuelRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
//import static com.cleman.inventoryserviceapplication.model.ReservedFuel.SEQUENCE_NAME;

import java.util.List;

@EnableKafka
@Service
public class InventoryServiceImpl implements InventoryService {


    @Value("${order.topic.name}")
    private String topicName;

    @Value("${schedule.topic.name}")
    private String reserveTopicName;


    @Autowired
    OrderRepository orderRepository;

    @Autowired
    AvailableFuelRepository availableFuelRepository;

    @Autowired
    ReservedFuelRepository reservedFuelRepository;


    SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    ObjectMapper objectMapper = new ObjectMapper();


    @KafkaListener(topics = "ordertopic",groupId = "groupId")
    public void processOrder(String message){
        System.out.println("Received Message : " + message);
        try {
            Order order = objectMapper.readValue(message, Order.class);
            System.out.println(">>>>>>>>>>>>>>>>>>>>"+order);
            AvailableFuel availableFuel = availableFuelRepository.findById(order.getFuelTypeId()).get();
            System.out.println("++++++++++++++++++++++++++++"+availableFuel.getAvailableFuelCapacity());
            System.out.println("++++++++++++++++++++++++++++"+order.getFuelCapacity());

            if(availableFuel.getAvailableFuelCapacity() > order.getFuelCapacity()){
                availableFuel.setAvailableFuelCapacity(availableFuel.getAvailableFuelCapacity() - order.getFuelCapacity());
                order.setFuelType(availableFuel.getFuelType());
                order.setOrderStatus("allocation complete");
                orderRepository.save(order);
                ReservedFuel reservedFuel = new ReservedFuel();

                if(order.getOrderStatus().equals("allocation complete")){
                    reservedFuel.setOrderReferenceId(order.getOrderId());
                    reservedFuel.setOrderId(order.getOrderId());
                    reservedFuel.setFuelStationName(order.getFuelStationName());
                    reservedFuel.setFuelStationNumber(order.getFuelStationNumber());
                    reservedFuel.setFuelType(availableFuel.getFuelType());
                    reservedFuel.setFuelCapacity(order.getFuelCapacity());
                    reservedFuel.setOrderStatus("fuel allocated");
                    reservedFuelRepository.save(reservedFuel);
                }

                String orderStr = null;
                try {
                    orderStr = objectMapper.writeValueAsString(reservedFuel);
                }catch (JsonProcessingException e){
                    e.printStackTrace();
                }
                kafkaTemplate.send(reserveTopicName,orderStr);
                System.out.println(">>>>>>>>>" +orderStr);

                availableFuelRepository.save(availableFuel);


            }else {
                order.setOrderStatus("allocation failed");
                orderRepository.save(order);
            }
            orderRepository.save(order);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public AvailableFuel addFuel(AvailableFuel availableFuel){
        return availableFuelRepository.save(availableFuel);
    }

    public List<AvailableFuel> getFuel(){
        return availableFuelRepository.findAll();
    }

    @Override
    public List<ReservedFuel> viewAllStatus() {
        return reservedFuelRepository.findAll();
    }
}
