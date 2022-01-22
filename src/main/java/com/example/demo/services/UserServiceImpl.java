package com.example.demo.services;


import com.example.demo.domain.Trainer;
import com.example.demo.domain.User;
import com.example.demo.repository.TrainerRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final TrainerService trainerService;


    public UserServiceImpl(UserRepository userRepository, TrainerService trainerService) {
        this.userRepository = userRepository;
        this.trainerService = trainerService;
    }


    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    public void becomeTrainer(User user) {
        user.setTrainer(true);
        Trainer trainer = new Trainer(user.getUsername());
        trainerService.save(trainer);
    }
}
