package com.interview.service;

import com.interview.model.TvShow;

import java.util.List;

public interface ShowRecommendationService {
    TvShow recommendShow(String userName);
    void resetRecommendations(String userName);
    List<TvShow> fetchRecommendationHistory(String userName);
}
