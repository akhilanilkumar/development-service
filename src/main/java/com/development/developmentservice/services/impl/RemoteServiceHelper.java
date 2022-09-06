package com.development.developmentservice.services.impl;

import com.development.developmentservice.model.LeaderDTO;
import com.development.developmentservice.model.PartyDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Component
public final class RemoteServiceHelper {

    private final RestTemplate restTemplate = new RestTemplate();
    @Value("${uri.leader-service}")
    private String LEADER_SERVICE_URI;
    @Value("${uri.party-service}")
    private String PARTY_SERVICE_URI;

    /**
     * Call Leader service to get the leader information based on the ID
     *
     * @param partyId
     * @param leaderId
     * @return
     */
    public Optional<LeaderDTO> findLeaderById(Long partyId, Long leaderId) {
        final String URI = LEADER_SERVICE_URI + "find/" + partyId + "/" + leaderId;
        return Optional.ofNullable(restTemplate.getForObject(URI, LeaderDTO.class));
    }

    /**
     * Get Party details using party id from PartyService
     *
     * @param partyId
     * @return
     */
    public Optional<PartyDTO> findPartyById(Long partyId) {
        return Optional.ofNullable(restTemplate.getForObject(PARTY_SERVICE_URI + partyId, PartyDTO.class));
    }
}
