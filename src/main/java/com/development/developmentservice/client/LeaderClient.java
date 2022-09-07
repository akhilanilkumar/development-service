package com.development.developmentservice.client;

import com.development.developmentservice.model.LeaderDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "${uri.leader-service}", name = "leader-service")
public interface LeaderClient {

    @GetMapping(value = "find/{partyId}/{leaderId}")
    LeaderDTO getLeaderByPartyIdAndLeaderId(@PathVariable Long partyId, @PathVariable Long leaderId);

}
