package com.cleman.inventoryserviceapplication.repository;


import com.cleman.inventoryserviceapplication.model.AvailableFuel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvailableFuelRepository extends MongoRepository<AvailableFuel, Integer> {

}