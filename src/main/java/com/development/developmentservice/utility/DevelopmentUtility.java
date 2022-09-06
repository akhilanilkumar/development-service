package com.development.developmentservice.utility;

import com.development.developmentservice.entity.Development;
import com.development.developmentservice.model.DevelopmentDTO;
import lombok.extern.log4j.Log4j2;

@Log4j2
public final class DevelopmentUtility {

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

}
