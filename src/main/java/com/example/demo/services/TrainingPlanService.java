package com.example.demo.services;

import com.example.demo.domain.Trainer;
import com.example.demo.domain.TrainingPlan;

import java.util.List;

public interface TrainingPlanService {

    TrainingPlan save(TrainingPlan trainingPlan);

    List<TrainingPlan> findAll();

    List<TrainingPlan> findAllByTrainer(Trainer t);

    TrainingPlan findPlanById(Long id);


}
