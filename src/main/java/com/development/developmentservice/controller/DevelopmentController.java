package com.development.developmentservice.controller;

import com.development.developmentservice.exception.NoSuchLeaderExistException;
import com.development.developmentservice.exception.NoSuchPartyExistException;
import com.development.developmentservice.model.DevelopmentDTO;
import com.development.developmentservice.services.DevelopmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "development")
public class DevelopmentController {

    @Autowired
    private DevelopmentService developmentService;

    @GetMapping(value = "works/{partyId}/{leaderId}")
    public List<DevelopmentDTO> getDevelopmentDetails(@PathVariable Long partyId, @PathVariable Long leaderId) {
        return developmentService.getAssignedDevelopmentWorks(partyId, leaderId);
    }

    @PostMapping(value = "assign-work")
    public DevelopmentDTO assignDevWorks(@Valid @RequestBody DevelopmentDTO developmentDTO) throws NoSuchLeaderExistException, NoSuchPartyExistException {
        return developmentService.assignDevelopmentWork(developmentDTO);
    }
}
