package com.example.demo.services;

import com.example.demo.domain.Trainer;
import com.example.demo.domain.TrainingPlan;
import com.example.demo.repository.TrainingPlanRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingPlanServiceImpl implements TrainingPlanService{

    private final TrainingPlanRepository trainingPlanRepository;

    public TrainingPlanServiceImpl(TrainingPlanRepository trainingPlanRepository) {
        this.trainingPlanRepository = trainingPlanRepository;
    }

    @Override
    public TrainingPlan save(TrainingPlan trainingPlan) {
        return trainingPlanRepository.save(trainingPlan);
    }

    @Override
    public List<TrainingPlan> findAll() {
        return trainingPlanRepository.findAll();
    }

    @Override
    public List<TrainingPlan> findAllByTrainer(Trainer t) {
        return trainingPlanRepository.findAllByTrainer(t);
    }

    @Override
    public TrainingPlan findPlanById(Long id) {
        return trainingPlanRepository.findPlanByById(id);
    }
}
