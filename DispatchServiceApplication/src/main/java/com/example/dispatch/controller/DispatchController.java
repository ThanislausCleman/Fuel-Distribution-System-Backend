package com.example.dispatch.controller;

import com.example.dispatch.model.Dispatch;
import com.example.dispatch.service.DispatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/dispatch")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class DispatchController {

    DispatchService dispatchService;

    @GetMapping
    public ResponseEntity<List<Dispatch>> getDispatchables(){
        return dispatchService.getDispatchables();
    }
}
