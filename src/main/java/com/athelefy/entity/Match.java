package com.athelefy.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Match implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String opponent;
    private LocalDateTime dateTime;
    private String location;
    private String result;
    private Boolean isPlayingHome;
    @ManyToOne
    private Sport sport;
    @ManyToOne
    private Team team;

    public Match() {}

    public Match(Long id, String opponent, LocalDateTime dateTime, String location, String result, Boolean isPlayingHome, Sport sport, Team team) {
        this.id = id;
        this.opponent = opponent;
        this.dateTime = dateTime;
        this.location = location;
        this.result = result;
        this.isPlayingHome = isPlayingHome;
        this.sport = sport;
        this.team = team;
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

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
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
                ", sport=" + sport +
                ", team=" + team +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Match match = (Match) o;
        return Objects.equals(id, match.id) && Objects.equals(opponent, match.opponent) && Objects.equals(dateTime, match.dateTime) && Objects.equals(location, match.location) && Objects.equals(result, match.result) && Objects.equals(isPlayingHome, match.isPlayingHome) && Objects.equals(sport, match.sport) && Objects.equals(team, match.team);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, opponent, dateTime, location, result, isPlayingHome, sport, team);
    }
}
