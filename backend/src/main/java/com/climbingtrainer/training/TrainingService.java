package com.climbingtrainer.training;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TrainingService {

    private final TrainingRepository trainingRepository;

    public TrainingService(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    public List<TrainingSession> findAll() {
        return trainingRepository.findAll();
    }
}
