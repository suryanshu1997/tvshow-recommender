package com.interview.repository;

import lombok.Getter;
import lombok.Setter;
import com.interview.model.User;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
@Component
public class UserData {
    Map<String, User> users;
    Map<String, Set<Long>> userRecommendationHistory;

    public UserData() {
        this.users = new HashMap<>();
        this.userRecommendationHistory = new HashMap<>();
    }
}
