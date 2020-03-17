package com.kisannetwork.smsservice.smsservice.repository;

import com.kisannetwork.smsservice.smsservice.domain.Record;
import org.springframework.data.repository.CrudRepository;

public interface RecordRepository extends CrudRepository<Record, Long> {

}
