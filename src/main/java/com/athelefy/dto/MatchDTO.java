package com.athelefy.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class MatchDTO implements Serializable {

    private Long id;
    private String opponent;
    private LocalDateTime dateTime;
    private String location;
    private String result;
    private Boolean isPlayingHome;
    private SportDTO sportDTO;
    private TeamDTO teamDTO;

    public MatchDTO() {}

    public MatchDTO(Long id, String opponent, LocalDateTime dateTime, String location, String result, Boolean isPlayingHome, SportDTO sportDTO, TeamDTO teamDTO) {
        this.id = id;
        this.opponent = opponent;
        this.dateTime = dateTime;
        this.location = location;
        this.result = result;
        this.isPlayingHome = isPlayingHome;
        this.sportDTO = sportDTO;
        this.teamDTO = teamDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOpponent() {
        return opponent;
    }

    public void setOpponent(String opponent) {
        this.opponent = opponent;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Boolean getPlayingHome() {
        return isPlayingHome;
    }

    public void setPlayingHome(Boolean playingHome) {
        isPlayingHome = playingHome;
    }

    public SportDTO getSport() {
        return sportDTO;
    }

    public void setSport(SportDTO sportDTO) {
        this.sportDTO = sportDTO;
    }

    public TeamDTO getTeam() {
        return teamDTO;
    }

    public void setTeam(TeamDTO teamDTO) {
        this.teamDTO = teamDTO;
    }

    @Override
    public String toString() {
        return "Matches{" +
                "id=" + id +
                ", opponent='" + opponent + '\'' +
                ", dateTime=" + dateTime +
                ", location='" + location + '\'' +
                ", result='" + result + '\'' +
                ", isPlayingHome=" + isPlayingHome +
                ", sport=" + sportDTO +
                ", team=" + teamDTO +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MatchDTO matchDTO = (MatchDTO) o;
        return Objects.equals(id, matchDTO.id) && Objects.equals(opponent, matchDTO.opponent) && Objects.equals(dateTime, matchDTO.dateTime) && Objects.equals(location, matchDTO.location) && Objects.equals(result, matchDTO.result) && Objects.equals(isPlayingHome, matchDTO.isPlayingHome) && Objects.equals(sportDTO, matchDTO.sportDTO) && Objects.equals(teamDTO, matchDTO.teamDTO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, opponent, dateTime, location, result, isPlayingHome, sportDTO, teamDTO);
    }
}
