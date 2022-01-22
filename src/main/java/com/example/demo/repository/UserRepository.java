package com.example.demo.repository;

import com.example.demo.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User,Long> {
    @Query("select u from User u")
    List<User> findAll();

    @Query("select u from User u where u.username = :username")
    User findUserByUsername(String username);
}
