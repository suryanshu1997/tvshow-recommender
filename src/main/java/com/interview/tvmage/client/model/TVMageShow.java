package com.interview.tvmage.client.model;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TVMageShow {
    private Long id;
    private String name;
    private String type;
    private String language;
    private List<String> genres;
    private Long runTime;
    private Rating rating;
    private String summary;
}
