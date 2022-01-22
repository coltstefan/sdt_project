package com.example.demo.domain;


import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@EqualsAndHashCode(exclude = {"trainingPlan"})
@ToString(exclude = {"trainingPlan"})
@NoArgsConstructor
public class Trainer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "trainer" , cascade = CascadeType.ALL)
    private Set<TrainingPlan> trainingPlan = new HashSet<>();

    public void addTrainingPlan(TrainingPlan tp){
        trainingPlan.add(tp);
        tp.setTrainer(this);
    }

    public Trainer(String name) {
        this.name = name;
    }
}
