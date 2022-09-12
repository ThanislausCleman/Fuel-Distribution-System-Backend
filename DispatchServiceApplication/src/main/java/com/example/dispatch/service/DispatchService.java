package com.example.dispatch.service;

import com.example.dispatch.model.Dispatch;
import com.example.dispatch.repository.DispatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class DispatchService {

    @Autowired
    DispatchRepository dispatchRepository;

    public Dispatch dispatchDelivery(int orderId, String date) {
        Dispatch dispatch = new Dispatch();
        dispatch.setOrderId(orderId);
        dispatch.setDate(date);

        return saveDispatch(dispatch);
    }

    public Dispatch saveDispatch(Dispatch dispatch) {
        return dispatchRepository.save(dispatch);
    }

    public ResponseEntity<List<Dispatch>> getDispatchables() {
        return ResponseEntity.status(HttpStatus.OK).body(dispatchRepository.findAll());
    }
}
