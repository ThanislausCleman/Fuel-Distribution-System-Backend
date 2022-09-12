package com.cleman.scheduleserviceapplication.service;

import com.cleman.scheduleserviceapplication.model.Schedule;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ScheduleService {
    List<Schedule> viewAll();

    List<Schedule> findByOrderId(String orderId);

}
