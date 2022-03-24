package com.interview.model;

import lombok.*;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TvShow {
    private Long id;
    private String name;
    private String type;
    private String language;
    private List<String> genre;
    private Long runTime;
    private Float rating;
    private String summary;
}
