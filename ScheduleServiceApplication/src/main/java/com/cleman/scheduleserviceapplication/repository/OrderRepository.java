package com.cleman.scheduleserviceapplication.repository;


import com.cleman.scheduleserviceapplication.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {
}

