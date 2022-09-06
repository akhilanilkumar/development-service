package com.development.developmentservice.services;

import com.development.developmentservice.entity.Development;
import com.development.developmentservice.model.DevelopmentDTO;
import com.development.developmentservice.model.LeaderDTO;
import com.development.developmentservice.model.PartyDTO;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

public final class DevelopmentUtility {

    private static final RestTemplate restTemplate = new RestTemplate();

    private static final String LEADER_SERVICE_URI = "http://localhost:9092/leader/";

    private static final String PARTY_SERVICE_URI = "http://localhost:9091/party/";


    public static Development convertToEntity(DevelopmentDTO developmentDTO) {
        Development development = new Development();
        development.setId(developmentDTO.getId());
        development.setPartyId(developmentDTO.getPartyId());
        development.setLeaderId(developmentDTO.getLeaderId());
        development.setTitle(developmentDTO.getTitle());
        development.setActivity(developmentDTO.getActivity());
        development.setBudget(developmentDTO.getBudget());
        development.setState(developmentDTO.getState());
        development.setActivityMonth(developmentDTO.getActivityMonth());
        development.setActivityYear(developmentDTO.getActivityYear());
        return development;
    }

    public static DevelopmentDTO convertToDTO(Development development) {
        DevelopmentDTO developmentDTO = new DevelopmentDTO();
        developmentDTO.setId(development.getId());
        developmentDTO.setPartyId(development.getPartyId());
        developmentDTO.setLeaderId(development.getLeaderId());
        developmentDTO.setTitle(development.getTitle());
        developmentDTO.setActivity(development.getActivity());
        developmentDTO.setBudget(development.getBudget());
        developmentDTO.setState(development.getState());
        developmentDTO.setActivityMonth(development.getActivityMonth());
        developmentDTO.setActivityYear(development.getActivityYear());
        return developmentDTO;
    }

    /**
     * Call Leader service to get the leader information based on the ID
     *
     * @param partyId
     * @param leaderId
     * @return
     */
    public static Optional<LeaderDTO> findLeaderById(Long partyId, Long leaderId) {
        final String URI = LEADER_SERVICE_URI + "find/" + partyId + "/" + leaderId;
        return Optional.ofNullable(restTemplate.getForObject(URI, LeaderDTO.class));
    }

    /**
     * Get Party details using party id from PartyService
     *
     * @param partyId
     * @return
     */
    public static Optional<PartyDTO> findPartyById(Long partyId) {
        return Optional.ofNullable(restTemplate.getForObject(PARTY_SERVICE_URI + partyId, PartyDTO.class));
    }
}
