package com.example.demo.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode(exclude = {"trainingPlan"})
@ToString(exclude = {"trainingPlan"})
@NoArgsConstructor
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private int repetitions;

    private int sets;

    @ManyToOne
    private TrainingPlan trainingPlan;

    public Exercise(String name, String description, int repetitions, int sets) {
        this.name = name;
        this.description = description;
        this.repetitions = repetitions;
        this.sets = sets;
    }
}
