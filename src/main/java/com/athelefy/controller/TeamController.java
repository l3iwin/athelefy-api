package com.athelefy.controller;

import com.athelefy.dto.ClubDTO;
import com.athelefy.dto.TeamDTO;
import com.athelefy.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/team")
public class TeamController {

    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping(path = "/squad")
    public ResponseEntity<TeamDTO> getSquadById(@RequestParam Long teamId) {
        return new ResponseEntity<>(teamService.getSquadByTeamId(teamId), HttpStatus.OK);
    }

    @GetMapping(path = "/club")
    public ResponseEntity<TeamDTO> getClubByTeamId(@RequestParam Long teamId) {
        return new ResponseEntity<>(teamService.getClubByTeamId(teamId), HttpStatus.OK);
    }

}
