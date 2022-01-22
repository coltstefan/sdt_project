package com.example.demo;

import com.example.demo.domain.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static User currentUser = new User();

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
