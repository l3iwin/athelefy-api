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
    private String season;
    private String round;
    @ManyToOne
    private Competition competition;
    @ManyToOne
    private Team team;

    public Match() {}

    public Match(Long id, String opponent, LocalDateTime dateTime, String location, String result, Boolean isPlayingHome, String season, String round) {
        this.id = id;
        this.opponent = opponent;
        this.dateTime = dateTime;
        this.location = location;
        this.result = result;
        this.isPlayingHome = isPlayingHome;
        this.season = season;
        this.round = round;
    }

    public Match(Long id, String opponent, LocalDateTime dateTime, String location, String result, Boolean isPlayingHome, String season, String round, Competition competition, Team team) {
        this.id = id;
        this.opponent = opponent;
        this.dateTime = dateTime;
        this.location = location;
        this.result = result;
        this.isPlayingHome = isPlayingHome;
        this.season = season;
        this.round = round;
        this.competition = competition;
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

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "Match{" +
                "id=" + id +
                ", opponent='" + opponent + '\'' +
                ", dateTime=" + dateTime +
                ", location='" + location + '\'' +
                ", result='" + result + '\'' +
                ", isPlayingHome=" + isPlayingHome +
                ", competition=" + competition +
                ", team=" + team +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Match match = (Match) o;
        return Objects.equals(id, match.id) && Objects.equals(opponent, match.opponent) && Objects.equals(dateTime, match.dateTime) && Objects.equals(location, match.location) && Objects.equals(result, match.result) && Objects.equals(isPlayingHome, match.isPlayingHome) && Objects.equals(competition, match.competition) && Objects.equals(team, match.team);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, opponent, dateTime, location, result, isPlayingHome, competition, team);
    }
}
