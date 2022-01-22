package com.example.demo.controllers;

import com.example.demo.domain.Exercise;
import com.example.demo.domain.StringEncap;
import com.example.demo.domain.Trainer;
import com.example.demo.domain.TrainingPlan;
import com.example.demo.services.ExerciseService;
import com.example.demo.services.TrainerService;
import com.example.demo.services.TrainingPlanService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/training_plans")
public class TrainingPlanController {

    private final TrainerService trainerService;
    private final TrainingPlanService trainingPlanService;
    private final ExerciseService exerciseService;

    public TrainingPlanController(TrainerService trainerService, TrainingPlanService trainingPlanService, ExerciseService exerciseService) {
        this.trainerService = trainerService;
        this.trainingPlanService = trainingPlanService;
        this.exerciseService = exerciseService;
    }

    @GetMapping("/create/{id}")
    public String completeTrainingPlanName(@PathVariable Long id , Model model){

        TrainingPlan tp = trainingPlanService.findPlanById(id);
        model.addAttribute("trainingPlan" , tp);
        StringEncap name = new StringEncap();
        model.addAttribute("nameBig",name);


        return "add_training_plan";

    }

    @PostMapping("/save/{id}")
    public String createTrainingPlan(@PathVariable Long id, RedirectAttributes redirectAttributes){

        Trainer trainer = trainerService.findTrainerById(id);

        TrainingPlan trainingPlan = new TrainingPlan();
        trainer.addTrainingPlan(trainingPlan);

        trainingPlanService.save(trainingPlan);

        redirectAttributes.addAttribute("id", trainingPlan.getId());

        return "redirect:/training_plans/create/{id}";

    }

    @PostMapping("/update/name/{id}")
    public String updateTrainingPlanName(@PathVariable("id") Long id , @ModelAttribute("name") StringEncap name){

        TrainingPlan tp = trainingPlanService.findPlanById(id);

        System.out.println(name);

        tp.setName(name.getName());
        trainingPlanService.save(tp);
        System.out.println(name);
        System.out.println(tp);

        return "redirect:/users";

    }

//    @PostMapping("/update/list/{id}")
//    public String updateTrainingPlanExercises(@PathVariable("id") Long id , @ModelAttribute("exerciseList") List<Exercise> exerciseList){
//
//    }

    @GetMapping("/{name}")
    public String getAllPlans(@PathVariable String name , Model model){

        Trainer trainer = trainerService.findTrainerByName(name);
        List<TrainingPlan> trainingPlanList = trainingPlanService.findAllByTrainer(trainer);

        model.addAttribute("trainer", trainer);
        model.addAttribute("trainingPlans",trainingPlanList);


        return "trainer_locker";

    }
}
