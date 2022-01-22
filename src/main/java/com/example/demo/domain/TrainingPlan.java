package com.example.demo.domain;


import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@EqualsAndHashCode(exclude = {"trainer" , "exercise"})
@ToString(exclude = {"trainer" , "exercise"})
@NoArgsConstructor
public class TrainingPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String name;

    @OneToMany(mappedBy = "trainingPlan", cascade = CascadeType.ALL)
    Set<Exercise> exerciseList = new HashSet<>();


    public void addExercise(Exercise exercise){
       exercise.setTrainingPlan(this);
        exerciseList.add(exercise);
    }


    @ManyToOne
    private Trainer trainer;




}
