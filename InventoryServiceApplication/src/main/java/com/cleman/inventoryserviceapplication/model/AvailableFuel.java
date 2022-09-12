package com.cleman.inventoryserviceapplication.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("AvailableFuel")
public class AvailableFuel {

    @Id
    private int fuelTypeId;
    private String fuelType;
    private int availableFuelCapacity;

    public AvailableFuel() {
    }

    public AvailableFuel(String fuelType, Integer availableFuelCapacity) {
        this.fuelType = fuelType;
        this.availableFuelCapacity = availableFuelCapacity;
    }

    public int getFuelTypeId() {
        return fuelTypeId;
    }

    public void setFuelTypeId(int fuelTypeId) {
        this.fuelTypeId = fuelTypeId;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public int getAvailableFuelCapacity() {
        return availableFuelCapacity;
    }

    public void setAvailableFuelCapacity(int availableFuelCapacity) {
        this.availableFuelCapacity = availableFuelCapacity;
    }

    @Override
    public String toString() {
        return "AvailableFuel{" +
                "fuelTypeId='" + fuelTypeId + '\'' +
                ", fuelType='" + fuelType + '\'' +
                ", availableFuelCapacity=" + availableFuelCapacity +
                '}';
    }
}
