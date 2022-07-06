package com.senpiper.liv2train2.repository;

import com.senpiper.liv2train2.model.TrainingCenter;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingCenterRepository extends MongoRepository<TrainingCenter, String>, CustomTrainingCenterRepository {}
