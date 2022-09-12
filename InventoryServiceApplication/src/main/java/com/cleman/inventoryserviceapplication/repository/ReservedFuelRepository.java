package com.cleman.inventoryserviceapplication.repository;


import com.cleman.inventoryserviceapplication.model.ReservedFuel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReservedFuelRepository extends MongoRepository<ReservedFuel, String> {
}
