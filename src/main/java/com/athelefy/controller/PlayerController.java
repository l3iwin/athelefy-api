package com.athelefy.controller;

import com.athelefy.dto.PlayerSummaryDTO;
import com.athelefy.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/player")
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping()
    public ResponseEntity<List<PlayerSummaryDTO>> getPlayersByTeamId(@RequestParam Long teamId) {
        return new ResponseEntity<>(playerService.getPlayersByTeamId(teamId), HttpStatus.OK);
    }

}
