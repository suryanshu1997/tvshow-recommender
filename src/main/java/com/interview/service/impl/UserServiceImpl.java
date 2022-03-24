package com.interview.service.impl;

import com.interview.exception.UserAlreadyRegisteredException;
import com.interview.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.interview.repository.UserData;
import com.interview.service.UserService;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserData userData;

    @Override
    public User registerUser(User user) {
        if(userData.getUsers().containsKey(user.getUserName())){
            throw new UserAlreadyRegisteredException("User with username: " + user.getUserName() + " already exists");
        }
        userData.getUsers().put(user.getUserName(),user);
        userData.getUserRecommendationHistory().put(user.getUserName(),new HashSet<>());
        return userData.getUsers().get(user.getUserName());
    }

    @Override
    public List<User> getUsers() {
       return userData.getUsers().values().stream().collect(Collectors.toList());
    }
}
