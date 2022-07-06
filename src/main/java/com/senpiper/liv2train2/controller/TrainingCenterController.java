package com.senpiper.liv2train2.controller;

import com.senpiper.liv2train2.model.TrainingCenter;
import com.senpiper.liv2train2.service.TrainingCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

// Choosing to import each dependency explicitly rather than wildcard to improve readability and preventing conflict at compile time
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@RestController
public class TrainingCenterController {

    @Autowired
    private TrainingCenterService trainingCenterService;

    @GetMapping("/centers")
    public ResponseEntity<?> getTrainingCenters(@RequestParam Map<String, String> params ){
        return ResponseEntity.ok().body(trainingCenterService.getTrainingCenters(params));
    }

    @PostMapping("/centers")
    public ResponseEntity<?> createTrainingCenter(@RequestBody TrainingCenter newTrainingCenter){
        newTrainingCenter.setCreatedOn(System.currentTimeMillis());
        return ResponseEntity.ok().body(trainingCenterService.addTrainingCenter(newTrainingCenter));

    }
}
