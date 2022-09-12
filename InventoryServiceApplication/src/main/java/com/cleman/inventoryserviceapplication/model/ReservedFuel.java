package com.cleman.inventoryserviceapplication.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Transient;
import java.time.LocalDate;

@Document("ReservedFuel")
public class ReservedFuel {

//    @Transient
//    public static final String SEQUENCE_NAME = "ReservedFuel_Sequence";
    @Id
    private String orderReferenceId;

    private String orderId;
    private String fuelStationName;
    private String fuelStationNumber;
    private String fuelType;
    private int fuelCapacity;
    private String orderStatus;

    private LocalDate date;

    public ReservedFuel() {
    }

    public ReservedFuel(String orderId, String fuelStationName, String fuelStationNumber, String fuelType, int fuelCapacity, String orderStatus, LocalDate date) {
        this.orderId = orderId;
        this.fuelStationName = fuelStationName;
        this.fuelStationNumber = fuelStationNumber;
        this.fuelType = fuelType;
        this.fuelCapacity = fuelCapacity;
        this.orderStatus = orderStatus;
        this.date = date;
    }

    public String getOrderReferenceId() {
        return orderReferenceId;
    }

    public void setOrderReferenceId(String orderReferenceId) {
        this.orderReferenceId = orderReferenceId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getFuelStationName() {
        return fuelStationName;
    }

    public void setFuelStationName(String fuelStationName) {
        this.fuelStationName = fuelStationName;
    }

    public String getFuelStationNumber() {
        return fuelStationNumber;
    }

    public void setFuelStationNumber(String fuelStationNumber) {
        this.fuelStationNumber = fuelStationNumber;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public int getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(int fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}

