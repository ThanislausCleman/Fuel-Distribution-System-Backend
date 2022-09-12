package com.cleman.scheduleserviceapplication.model;


import org.springframework.data.annotation.Id;

public class ScheduleSequence {

    @Id
    private String scheduledId;
    private int seqNo;

    public ScheduleSequence() {
    }

    public ScheduleSequence(String scheduledId, int seqNo) {
        this.scheduledId = scheduledId;
        this.seqNo = seqNo;
    }

    public String getScheduledId() {
        return scheduledId;
    }

    public void setScheduledId(String scheduledId) {
        this.scheduledId = scheduledId;
    }

    public int getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(int seqNo) {
        this.seqNo = seqNo;
    }
}

