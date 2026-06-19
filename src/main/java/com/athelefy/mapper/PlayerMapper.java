package com.athelefy.mapper;

import com.athelefy.dto.PlayerDTO;
import com.athelefy.dto.TeamDTO;
import com.athelefy.entity.Player;
import com.athelefy.entity.Team;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlayerMapper {

    PlayerDTO toPlayerDTO(Player player);
    Player toPlayer(PlayerDTO playerDTO);

}
