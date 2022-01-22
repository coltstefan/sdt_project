package com.example.demo.repository;

import com.example.demo.domain.Exercise;
import com.example.demo.domain.TrainingPlan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ExerciseRepository extends CrudRepository<Exercise,Long> {

    @Query("select e from Exercise e")
    List<Exercise> findAll();

    @Query("select e from Exercise e where e.id = :id")
    Exercise findExerciseById(Long id);

    @Query("select e from Exercise e where e.name = :name")
    Exercise findExerciseByName(String name);

    @Query("select e from Exercise e where e.trainingPlan = :tp")
    Exercise findByPlan(TrainingPlan tp);
}
