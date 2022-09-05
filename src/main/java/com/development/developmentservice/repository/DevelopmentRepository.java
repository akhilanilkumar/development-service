package com.development.developmentservice.repository;

import com.development.developmentservice.entity.Development;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DevelopmentRepository extends JpaRepository<Development, Long> {

    Optional<List<Development>> findAllByLeaderIdAndPartyIdOrderByActivityYearDesc(Long leaderId, Long partyId);
}