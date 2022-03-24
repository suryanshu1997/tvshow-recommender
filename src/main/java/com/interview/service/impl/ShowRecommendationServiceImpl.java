package com.interview.service.impl;

import com.interview.exception.UserNotFoundException;
import com.interview.model.TvShow;
import com.interview.tvmage.client.TVClient;
import com.interview.tvmage.client.model.TVMageShow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.interview.repository.UserData;
import com.interview.service.ShowRecommendationService;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ShowRecommendationServiceImpl implements ShowRecommendationService {

    @Autowired
    private UserData userData;

    @Autowired
    private TVClient tvClient;

    @Override
    public TvShow recommendShow(String userName) {
        if(!userData.getUsers().containsKey(userName)){
            throw new UserNotFoundException("user with username " + userName + " does not exist");
        }
        long randomId;
        do{
            randomId = Double.valueOf(Math.random() * 10000).longValue();
        } while(userData.getUserRecommendationHistory().get(userName).contains(randomId));
        TVMageShow show = tvClient.fetchShow(randomId);
        userData.getUserRecommendationHistory().get(userName).add(randomId);
        return asTvShow(show);
    }

    @Override
    public void resetRecommendations(String userName) {
        if(!userData.getUsers().containsKey(userName)){
            throw new UserNotFoundException("user with username " + userName + " does not exist");
        }
        userData.getUserRecommendationHistory().get(userName).clear();
    }

    @Override
    public List<TvShow> fetchRecommendationHistory(String userName) {
        if(!userData.getUsers().containsKey(userName)){
            throw new UserNotFoundException("user with username " + userName + " does not exist");
        }
        return userData.getUserRecommendationHistory().get(userName)
                .stream() // can fasten up with parallelstream()
                .map(tvClient::fetchShow)
                .map(this::asTvShow)
                .collect(Collectors.toList());
    }

    private TvShow asTvShow(TVMageShow show) {
        return TvShow.builder()
                .id(show.getId())
                .rating(show.getRating().getAverage())
                .name(show.getName())
                .genre(show.getGenres())
                .language(show.getLanguage())
                .runTime(show.getRunTime())
                .summary(show.getSummary())
                .type(show.getType())
                .build();
    }
}
