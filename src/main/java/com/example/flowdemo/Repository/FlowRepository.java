package com.example.flowdemo.Repository;

import com.example.flowdemo.models.Flow;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlowRepository extends MongoRepository<Flow, String> {
}
