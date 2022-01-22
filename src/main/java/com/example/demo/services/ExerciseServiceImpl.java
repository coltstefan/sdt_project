package com.example.demo.services;

import com.example.demo.domain.Exercise;
import com.example.demo.domain.TrainingPlan;
import com.example.demo.repository.ExerciseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseServiceImpl implements ExerciseService{

    private final ExerciseRepository exerciseRepository;

    public ExerciseServiceImpl(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }


    @Override
    public Exercise save(Exercise exercise) {
        return exerciseRepository.save(exercise);
    }

    @Override
    public List<Exercise> findAll() {
        return exerciseRepository.findAll();
    }

    @Override
    public Exercise findExerciseById(Long id) {
        return exerciseRepository.findExerciseById(id);
    }

    @Override
    public Exercise findExerciseByName(String name) {
        return exerciseRepository.findExerciseByName(name);
    }

    @Override
    public Exercise findExerciseByPlan(TrainingPlan tp) {
        return exerciseRepository.findByPlan(tp);
    }
}
