package com.athelefy.service;

import com.athelefy.dto.PlayerSummaryDTO;
import com.athelefy.entity.Player;
import com.athelefy.mapper.PlayerMapper;
import com.athelefy.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final PlayerMapper playerMapper;

    public PlayerService(PlayerRepository playerRepository, PlayerMapper playerMapper) {
        this.playerRepository = playerRepository;
        this.playerMapper = playerMapper;
    }

    public List<PlayerSummaryDTO> getPlayersByTeamId(Long teamId) {
        Optional<List<Player>> optionalPlayers = playerRepository.findByTeams_Id(teamId);
        return optionalPlayers.map(playerMapper::toPlayerSummaryDTOList).orElse(null);
    }

}
