package com.athelefy.repository;

import com.athelefy.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;

public interface TeamRepository extends JpaRepository<Team, Long> {

    Optional<Set<Team>> findTeamsBy_CoachId(Long coachId);

}
