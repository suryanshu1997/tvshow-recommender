package com.interview.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class User {
    private String userName;
    private String displayName;
}
