package com.development.developmentservice.utility;

import com.development.developmentservice.entity.Activity;
import com.development.developmentservice.entity.Development;
import com.development.developmentservice.model.ActivityDTO;
import com.development.developmentservice.model.DevelopmentDTO;
import lombok.extern.log4j.Log4j2;

import java.util.Set;
import java.util.stream.Collectors;

@Log4j2
public final class DevelopmentUtility {

    public static Development convertToEntity(DevelopmentDTO developmentDTO) {
        Development development = new Development();
        development.setId(developmentDTO.getId());
        development.setPartyId(developmentDTO.getPartyId());
        development.setLeaderId(developmentDTO.getLeaderId());
        development.setTitle(developmentDTO.getTitle());
        Set<Activity> activities = developmentDTO.getActivities().stream()
                .map(DevelopmentUtility::convertToActivity)
                .peek(activity -> activity.setDevelopment(development))
                .collect(Collectors.toSet());
        development.setActivities(activities);
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
        Set<ActivityDTO> activityDTOS = development.getActivities()
                .stream().map(DevelopmentUtility::convertToActivityDTO).collect(Collectors.toSet());
        developmentDTO.setActivities(activityDTOS);
        developmentDTO.setBudget(development.getBudget());
        developmentDTO.setState(development.getState());
        developmentDTO.setActivityMonth(development.getActivityMonth());
        developmentDTO.setActivityYear(development.getActivityYear());
        return developmentDTO;
    }

    private static ActivityDTO convertToActivityDTO(Activity activity) {
        return new ActivityDTO(activity.getId(), activity.getActivity());
    }

    private static Activity convertToActivity(ActivityDTO activityDTO) {
        Activity activity = new Activity();
        activity.setId(activityDTO.getId());
        activity.setActivity(activityDTO.getActivity());
        return activity;
    }

}
