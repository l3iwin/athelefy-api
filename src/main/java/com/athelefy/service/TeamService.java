package com.athelefy.service;

import com.athelefy.dto.TeamDTO;
import com.athelefy.entity.Team;
import com.athelefy.mapper.TeamMapper;
import com.athelefy.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public TeamDTO getTeamsById(Long teamId){
        Optional<Team> optionalTeam = teamRepository.findById(teamId);
        System.out.println("Players da entidade: " + optionalTeam.map(Team::getPlayers).orElse(null));
        return optionalTeam.map(teamMapper::toTeamDTO).orElse(null);
    }

}
