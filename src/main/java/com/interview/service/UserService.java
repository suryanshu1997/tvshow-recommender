package com.interview.service;

import com.interview.model.User;

import java.util.List;

public interface UserService {
    User registerUser(User user);
    List<User> getUsers();
}
