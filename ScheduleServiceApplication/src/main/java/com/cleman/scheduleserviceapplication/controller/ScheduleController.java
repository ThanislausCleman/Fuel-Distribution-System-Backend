package com.cleman.scheduleserviceapplication.controller;


import com.cleman.scheduleserviceapplication.model.Schedule;
import com.cleman.scheduleserviceapplication.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/scheduled")
public class ScheduleController {

    @Autowired
    ScheduleService scheduleService;

    @RequestMapping(value = "/viewAll", method = RequestMethod.GET)
    public List<Schedule> viewAll(){
        return scheduleService.viewAll();
    }

    @RequestMapping(value = "/viewById/{id}", method = RequestMethod.GET)
    public List<Schedule> findByOrderId(@PathVariable("id") String orderId){
        return scheduleService.findByOrderId(orderId);
    }
}