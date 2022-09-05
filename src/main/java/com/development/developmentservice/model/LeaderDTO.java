package com.development.developmentservice.model;

import lombok.Data;

@Data
public class LeaderDTO {
    private Long id;

    private Long partyId;

    private String leaderName;

    private String leaderState;
}
