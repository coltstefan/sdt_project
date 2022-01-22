package com.example.demo.controllers;


import com.example.demo.domain.Exercise;
import com.example.demo.services.ExerciseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/exercises")
public class ExerciseController {

    private final ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @GetMapping()
    public String getExercises(Model model){

        model.addAttribute("exercises" , exerciseService.findAll());

        return "exercises";
    }

    @GetMapping("/{id}")
    public Exercise getExerciseById(@PathVariable Long id){
        return exerciseService.findExerciseById(id);
    }

    @GetMapping("/names/{name}")
    public Exercise getExerciseByName(@PathVariable String name){
        return exerciseService.findExerciseByName(name);
    }
}
