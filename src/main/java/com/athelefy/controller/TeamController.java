package com.athelefy.controller;

import com.athelefy.dto.TeamDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/team")
public class TeamController {

    @GetMapping()
    public ResponseEntity<TeamDTO> getTeamByCoachId(@RequestParam Long coachId){
        return new ResponseEntity<>(new TeamDTO(), HttpStatus.OK);
    }

}
