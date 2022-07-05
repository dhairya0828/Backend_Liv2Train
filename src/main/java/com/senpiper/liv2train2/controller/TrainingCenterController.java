package com.senpiper.liv2train2.controller;

import com.senpiper.liv2train2.model.TrainingCenter;
import com.senpiper.liv2train2.service.TrainingCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TrainingCenterController {

    @Autowired
    private TrainingCenterService trainingCenterService;

    @GetMapping("/centers")
    public ResponseEntity<?> getTrainingCenters(){
        return ResponseEntity.ok().body(trainingCenterService.getTrainingCenters());
    }

    @PostMapping("/centers")
    public ResponseEntity<?> createTrainingCenter(@RequestBody TrainingCenter newTrainingCenter){
        newTrainingCenter.setCreatedOn(System.currentTimeMillis());
        return ResponseEntity.ok().body(trainingCenterService.addTrainingCenter(newTrainingCenter));

    }
}
