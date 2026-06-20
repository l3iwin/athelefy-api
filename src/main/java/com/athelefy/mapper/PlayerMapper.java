package com.athelefy.mapper;

import com.athelefy.dto.PlayerDTO;
import com.athelefy.dto.PlayerSummaryDTO;
import com.athelefy.dto.TeamDTO;
import com.athelefy.entity.Player;
import com.athelefy.entity.Team;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface PlayerMapper {

    PlayerDTO toPlayerDTO(Player player);
    List<PlayerDTO> toPlayerDTOList(List<Player> players);
    Set<PlayerDTO> toPlayerDTOSet(Set<Player> players);

    Player toPlayer(PlayerDTO playerDTO);

    PlayerSummaryDTO toPlayerSummaryDTO(Player player);
    List<PlayerSummaryDTO> toPlayerSummaryDTOList(List<Player> players);
    Set<PlayerSummaryDTO> toPlayerSummaryDTOSet(Set<Player> players);

}
