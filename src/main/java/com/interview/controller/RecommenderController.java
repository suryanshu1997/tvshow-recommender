package com.interview.controller;

import com.interview.model.TvShow;
import com.interview.service.ShowRecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecommenderController {

    @Autowired
    ShowRecommendationService showRecommendationService;

    @PostMapping("v1/users/{userName}/recommendations")
    ResponseEntity<TvShow> recommendShow(@PathVariable  String userName){
        TvShow show = showRecommendationService.recommendShow(userName);
        return ResponseEntity.status(HttpStatus.CREATED).body(show);
    }

    @DeleteMapping("v1/users/{userName}/recommendations")
    void deleteRecommendations(@PathVariable  String userName){
        showRecommendationService.resetRecommendations(userName);
    }

    @GetMapping("v1/users/{userName}/recommendations")
    ResponseEntity<List<TvShow>>fetchRecommendationHistory(@PathVariable  String userName){
        List<TvShow> history = showRecommendationService.fetchRecommendationHistory(userName);
        return ResponseEntity.status(HttpStatus.OK).body(history);
    }
}
