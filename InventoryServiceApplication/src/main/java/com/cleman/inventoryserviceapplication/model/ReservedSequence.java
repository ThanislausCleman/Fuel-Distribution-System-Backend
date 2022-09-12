package com.cleman.inventoryserviceapplication.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("ReservedSequence")
public class ReservedSequence {

    @Id
    private String ReserveId;

    private int seqNo;

    public ReservedSequence() {
    }

    public ReservedSequence(String ReserveId, int seqNo) {
        this.ReserveId = ReserveId;
        this.seqNo = seqNo;
    }

    public String getFuelTypeId() {
        return ReserveId;
    }

    public void setFuelTypeId(String fuelTypeId) {
        this.ReserveId = fuelTypeId;
    }

    public int getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(int seqNo) {
        this.seqNo = seqNo;
    }
}

