package com.development.developmentservice.services.impl;

import com.development.developmentservice.client.LeaderClient;
import com.development.developmentservice.client.PartyClient;
import com.development.developmentservice.model.LeaderDTO;
import com.development.developmentservice.model.PartyDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Log4j2
public class RemoteServiceHelper {

    @Autowired
    private LeaderClient leaderClient;

    @Autowired
    private PartyClient partyClient;

    /**
     * Call Leader service to get the leader information based on the ID
     *
     * @param partyId
     * @param leaderId
     * @return
     */
    public Optional<LeaderDTO> findLeaderById(Long partyId, Long leaderId) {
        LeaderDTO leaderByPartyIdAndLeaderId = leaderClient.getLeaderByPartyIdAndLeaderId(partyId, leaderId);
        log.debug("Response from Leader Service {}", leaderByPartyIdAndLeaderId);
        return Optional.ofNullable(leaderByPartyIdAndLeaderId);
    }

    /**
     * Get Party details using party id from PartyService
     *
     * @param partyId
     * @return
     */
    public Optional<PartyDTO> findPartyById(Long partyId) {
        PartyDTO partyDetailsById = partyClient.getPartyDetailsById(partyId);
        log.debug("Response from Party Service {}", partyDetailsById);
        return Optional.ofNullable(partyDetailsById);
    }
}
