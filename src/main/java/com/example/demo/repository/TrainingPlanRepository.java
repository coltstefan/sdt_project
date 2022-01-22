package com.example.demo.repository;

import com.example.demo.domain.Trainer;
import com.example.demo.domain.TrainingPlan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TrainingPlanRepository extends CrudRepository<TrainingPlan,Long> {

    @Query("select t from TrainingPlan t")
    List<TrainingPlan> findAll();

    @Query("select t from TrainingPlan t where t.trainer = :trainer")
    List<TrainingPlan> findAllByTrainer(Trainer trainer);

    @Query("select t from TrainingPlan t where t.id = :id")
    TrainingPlan findPlanByById(Long id);

}
