package com.interview.tvmage.client;

import com.interview.tvmage.client.model.TVMageShow;

public interface TVClient {
    TVMageShow fetchShow(long randomId);
}
