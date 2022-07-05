package com.senpiper.liv2train2.service;

import com.senpiper.liv2train2.model.TrainingCenter;
import com.senpiper.liv2train2.repository.TrainingCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingCenterService {

    @Autowired
    private TrainingCenterRepository repo;

    public TrainingCenter addTrainingCenter(TrainingCenter trainingCenter){

        return repo.save(trainingCenter);
    }

    public List<TrainingCenter> getTrainingCenters(){
        return repo.findAll();
    }
}

