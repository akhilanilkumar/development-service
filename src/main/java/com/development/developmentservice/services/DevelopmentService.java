package com.development.developmentservice.services;

import com.development.developmentservice.exception.NoSuchLeaderExistException;
import com.development.developmentservice.exception.NoSuchPartyExistException;
import com.development.developmentservice.model.DevelopmentDTO;

import java.util.List;

public interface DevelopmentService {

    /**
     * Fetch all the development works assigned to a Political Leader.
     *
     * @param partyId
     * @param leaderId
     * @return
     */
    List<DevelopmentDTO> getAssignedDevelopmentWorks(Long partyId, Long leaderId);

    /**
     * Assign some development work to the Political leader.
     *
     * @param developmentDTO
     * @return
     */
    DevelopmentDTO assignDevelopmentWork(DevelopmentDTO developmentDTO) throws NoSuchLeaderExistException, NoSuchPartyExistException;
}
