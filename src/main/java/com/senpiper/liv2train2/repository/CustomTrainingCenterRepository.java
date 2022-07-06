package com.senpiper.liv2train2.repository;

import com.senpiper.liv2train2.model.TrainingCenter;

import java.util.List;
import java.util.Map;

// This is the interface for custom filtration on TrainingCenter
public interface CustomTrainingCenterRepository {

    List<TrainingCenter> findCenterByParams(Map<String, String> params);
}
