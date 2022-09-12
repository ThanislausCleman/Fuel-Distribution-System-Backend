package com.cleman.scheduleserviceapplication.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Transient;
import java.time.LocalDate;

@Document("Schedule")
public class Schedule {

    @Transient
    public static final String SEQUENCE_NAME = "Delivery_Sequence";
    @Id
    private int orderScheduleId;
    private String orderId;
    private String fuelStationName;
    private String fuelStationNumber;
    private int fuelTypeId;
    private String fuelType;
    private int fuelCapacity;
    private LocalDate deliveryDate;
    private String scheduleStatus;

    public Schedule() {
    }


    public Schedule(String orderId, String fuelStationName, String fuelStationNumber, int fuelTypeId, String fuelType, int fuelCapacity, LocalDate deliveryDate, String scheduleStatus) {
        this.orderId = orderId;
        this.fuelStationName = fuelStationName;
        this.fuelStationNumber = fuelStationNumber;
        this.fuelTypeId = fuelTypeId;
        this.fuelType = fuelType;
        this.fuelCapacity = fuelCapacity;
        this.deliveryDate = deliveryDate;
        this.scheduleStatus = scheduleStatus;
    }

    public int getOrderScheduleId() {
        return orderScheduleId;
    }

    public void setOrderScheduleId(int orderScheduleId) {
        this.orderScheduleId = orderScheduleId;
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

    public int getFuelTypeId() {
        return fuelTypeId;
    }

    public void setFuelTypeId(int fuelTypeId) {
        this.fuelTypeId = fuelTypeId;
    }


    public int getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(int fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getScheduleStatus() {
        return scheduleStatus;
    }

    public void setScheduleStatus(String scheduleStatus) {
        this.scheduleStatus = scheduleStatus;
    }

}

