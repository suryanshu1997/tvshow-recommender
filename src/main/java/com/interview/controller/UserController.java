package com.interview.controller;

import com.interview.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.interview.service.UserService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("v1/users")
    User registerUser(@RequestBody User user){
        return userService.registerUser(user);
    }

    @GetMapping("v1/users")
    List<User> registerUser(){
        return userService.getUsers();
    }
}
