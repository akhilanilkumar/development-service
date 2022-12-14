package com.development.developmentservice.client;

import com.development.developmentservice.model.PartyDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "${uri.party-service}", name = "party-service")
public interface PartyClient {

    @GetMapping(value = "{partyId}")
    PartyDTO getPartyDetailsById(@PathVariable Long partyId);
}
