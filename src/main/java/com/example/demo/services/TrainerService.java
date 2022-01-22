package com.example.demo.services;

import com.example.demo.domain.Trainer;

import java.util.List;

public interface TrainerService {

    Trainer save(Trainer trainer);
    List<Trainer> findAll();
    Trainer findTrainerById(Long id);
    Trainer findTrainerByName(String name);

}
