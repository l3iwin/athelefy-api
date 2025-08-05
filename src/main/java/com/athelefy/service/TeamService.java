package com.athelefy.service;

import com.athelefy.dto.TeamDTO;
import com.athelefy.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public Set<TeamDTO> getTeamsByCoachId(Long coachId){
//        return teamRepository.findTeamsBy_CoachId(coachId);
//        TODO: Mapper DTO to Entity & Entity to DTO
        return null;
    }

}
