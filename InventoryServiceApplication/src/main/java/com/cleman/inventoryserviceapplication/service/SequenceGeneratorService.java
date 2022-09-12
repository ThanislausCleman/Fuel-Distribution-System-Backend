package com.cleman.inventoryserviceapplication.service;

import com.cleman.inventoryserviceapplication.model.ReservedSequence;
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
        ReservedSequence sequence = mongoOperations.findAndModify(query(where("_ReserveId").is(sequenceName)),
                new Update().inc("seqNo",1), options().returnNew(true).upsert(true),
                ReservedSequence.class);
        return !Objects.isNull(sequence) ? sequence.getSeqNo() : 1;
    }
}
