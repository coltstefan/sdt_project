package com.example.demo.services;

import com.example.demo.domain.Exercise;
import com.example.demo.domain.TrainingPlan;

import java.util.List;

public interface ExerciseService {

    Exercise save(Exercise exercise);
    List<Exercise> findAll();
    Exercise findExerciseById(Long id);
    Exercise findExerciseByName(String name);
    Exercise findExerciseByPlan(TrainingPlan tp);

}
