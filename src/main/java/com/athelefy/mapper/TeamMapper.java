package com.athelefy.mapper;

import com.athelefy.dto.PlayerSummaryDTO;
import com.athelefy.dto.TeamDTO;
import com.athelefy.entity.Player;
import com.athelefy.entity.Team;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TeamMapper {

    @Mapping(source = "players", target = "players")
    TeamDTO toTeamDTO(Team team);

    @Mapping(source = "players", target = "players")
    Team toTeam(TeamDTO teamDTO);

    PlayerSummaryDTO toPlayerSummaryDTO(Player player);
}

