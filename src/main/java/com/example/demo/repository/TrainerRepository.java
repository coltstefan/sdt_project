package com.example.demo.repository;

import com.example.demo.domain.Trainer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TrainerRepository extends CrudRepository<Trainer,Long> {

    @Query("select t from Trainer t")
    List<Trainer> findAll();

    @Query("select t from Trainer t where t.id = :id")
    Trainer findTrainerById(Long id);

    @Query("select t from Trainer t where t.name = :name")
    Trainer findTrainerByName(String name);


}
