package com.interview.tvmage.client;

import com.interview.tvmage.client.model.TVMageShow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class TVMageClient implements TVClient{

    @Autowired
    RestTemplate restTemplate;

    @Override
    public TVMageShow fetchShow(long randomId) {
        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .scheme("https").host("api.tvmaze.com").path("/shows/{id}").buildAndExpand(randomId);
        return restTemplate.exchange(uriComponents.toUri(), HttpMethod.GET,null, TVMageShow.class).getBody();
    }
}
