package com.development.developmentservice.services.impl;

import com.development.developmentservice.entity.Development;
import com.development.developmentservice.exception.NoSuchLeaderExistException;
import com.development.developmentservice.exception.NoSuchPartyExistException;
import com.development.developmentservice.model.DevelopmentDTO;
import com.development.developmentservice.repository.DevelopmentRepository;
import com.development.developmentservice.services.DevelopmentService;
import com.development.developmentservice.services.DevelopmentUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DevelopmentServiceImpl implements DevelopmentService {

    @Autowired
    private DevelopmentRepository developmentRepository;

    /**
     * Assign some development work to the Political leader.
     *
     * @param developmentDTO
     * @return
     */
    @Override
    public DevelopmentDTO assignDevelopmentWork(DevelopmentDTO developmentDTO) throws NoSuchLeaderExistException, NoSuchPartyExistException {
        //        Check if the leader exists in the leader service
        DevelopmentUtility.findLeaderById(developmentDTO.getLeaderId())
                .orElseThrow(() -> new NoSuchLeaderExistException("No matching records found for Leader: " + developmentDTO.getLeaderId()));

        //        Check if the party exists
        DevelopmentUtility.findPartyById(developmentDTO.getPartyId())
                .orElseThrow(() -> new NoSuchPartyExistException("No matching records found for a Party: " + developmentDTO.getPartyId()));

        Development development = DevelopmentUtility.convertToEntity(developmentDTO);

        Development savedDev = developmentRepository.save(development);
        return DevelopmentUtility.convertToDTO(savedDev);
    }

    /**
     * Fetch all the development works assigned to a Political Leader.
     *
     * @param partyId
     * @param leaderId
     * @return
     */
    @Override
    public List<DevelopmentDTO> getAssignedDevelopmentWorks(Long partyId, Long leaderId) {
        return developmentRepository.findAllByLeaderIdAndPartyIdOrderByActivityYearDesc(leaderId, partyId)
                .orElseGet(List::of)
                .stream()
                .map(DevelopmentUtility::convertToDTO)
                .collect(Collectors.toList());
    }
}
