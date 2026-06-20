package com.athelefy.service;

import com.athelefy.dto.TeamDTO;
import com.athelefy.entity.Team;
import com.athelefy.mapper.TeamMapper;
import com.athelefy.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class TeamService {

    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;

    @Autowired
    public TeamService(TeamRepository teamRepository,  TeamMapper teamMapper) {
        this.teamRepository = teamRepository;
        this.teamMapper = teamMapper;
    }

    public TeamDTO getSquadByTeamId(Long teamId){
        Optional<Team> optionalTeam = teamRepository.findById(teamId);
        return optionalTeam.map(teamMapper::toTeamDTO).orElse(null);
    }

    public TeamDTO getClubByTeamId(Long teamId) {
        Optional<Team> optionalTeam = teamRepository.findById(teamId);
        return optionalTeam.map(teamMapper::toTeamDTO).orElse(null);
    }
}
