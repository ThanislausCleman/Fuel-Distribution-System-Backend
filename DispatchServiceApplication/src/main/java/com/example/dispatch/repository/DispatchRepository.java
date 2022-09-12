package com.example.dispatch.repository;

import com.example.dispatch.model.Dispatch;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DispatchRepository extends MongoRepository<Dispatch, Integer> {

}
