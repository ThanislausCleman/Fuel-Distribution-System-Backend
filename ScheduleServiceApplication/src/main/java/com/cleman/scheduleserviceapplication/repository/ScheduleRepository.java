package com.cleman.scheduleserviceapplication.repository;


import com.cleman.scheduleserviceapplication.model.Schedule;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends MongoRepository<Schedule, Integer> {

    List<Schedule> findByOrderId(String orderId);
}
