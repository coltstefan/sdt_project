package com.example.demo.controllers;

import com.example.demo.DemoApplication;
import com.example.demo.domain.User;
import com.example.demo.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping()
    public String login(Model model){

        User user = new User();
        model.addAttribute("user", user);

        return "login page";
    }


    @GetMapping("/register")
    public String register(Model model){

        User user = new User();
        model.addAttribute("user", user);

        return "register_page";
    }

    @GetMapping("/users")
    public String getUsers(Model model){

        List<User> users = userService.findAll();
        model.addAttribute("currUser", DemoApplication.currentUser);
        System.out.println(DemoApplication.currentUser.isTrainer());
        model.addAttribute("users", users);

        if(DemoApplication.currentUser.isTrainer()){
            return "trainer_unlocked_page";
        }
        return "all_users";
    }

    @PostMapping("/saveUser")
    public String saveUser( @ModelAttribute("user") User user) {

        userService.save(user);
        return "redirect:/";
    }

    @PostMapping("/loginUser")
    public String loginUser( @ModelAttribute("user") User user) {

        User currUser = userService.findUserByUsername(user.getUsername());
//
        if(currUser != null){
//
            if(currUser.getPassword().equals(user.getPassword())){
                DemoApplication.currentUser = currUser;

                return "redirect:/users";
            }
        }

        return "redirect:/";
    }

    @PostMapping("/users/createTrainer")
    public String createTrainer(){

        System.out.println("HERE");

        User user = userService.findUserByUsername(DemoApplication.currentUser.getUsername());
        System.out.println(user);
        userService.becomeTrainer(user);
        DemoApplication.currentUser = user;

        return "redirect:/users";
    }










}
