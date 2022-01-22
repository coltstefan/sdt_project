package com.example.demo.bootstrap;


import com.example.demo.domain.TrainingPlan;
import com.example.demo.services.ExerciseService;
import com.example.demo.services.TrainingPlanService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final ExerciseService exerciseService;
    private final TrainingPlanService trainingPlanService;

    public DataLoader(ExerciseService exerciseService, TrainingPlanService trainingPlanService) {
        this.exerciseService = exerciseService;
        this.trainingPlanService = trainingPlanService;
    }

    @Override
    public void run(String... args) throws Exception {

//        Exercise e1 = new Exercise("Genoflexiuni" , "Description", 10,10);
//        Exercise e2 = new Exercise("Tractiuni" , "Description", 10,10);
//        Exercise e3 = new Exercise("Flotari" , "Description", 10,10);
//
//        exerciseService.save(e1);
//        exerciseService.save(e2);
//        exerciseService.save(e3);
//
//        System.out.println(exerciseService.findExerciseByName("Genoflexiuni"));


    }
}
