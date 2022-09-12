package com.cleman.scheduleserviceapplication.service;


import com.cleman.scheduleserviceapplication.model.ScheduleSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Service
public class SequenceGeneratorService {

    @Autowired
    MongoOperations mongoOperations;

    public int getSequenceNumber(String sequenceName){
        ScheduleSequence sequence = mongoOperations.findAndModify(query(where("_scheduledId").is(sequenceName)),
                new Update().inc("seqNo",1), options().returnNew(true).upsert(true),
                ScheduleSequence.class);
        return !Objects.isNull(sequence) ? sequence.getSeqNo() : 1;
    }

    public LocalDate generateLocalDate(){

        LocalDate startDate = LocalDate.now();
        long start = startDate.toEpochDay();

        LocalDate endDate = LocalDate.now().plusDays(7); //end date
        long end = endDate.toEpochDay();

        long randomEpochDay = ThreadLocalRandom.current().longs(start, end).findAny().getAsLong();
        LocalDate date = LocalDate.ofEpochDay(randomEpochDay);
        System.out.println(date);
        return date;
    }
}
