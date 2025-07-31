package com.athelefy.entity.stats;

import com.athelefy.entity.Match;
import com.athelefy.entity.Team;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class HandballTeamStats implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double possessionPercent;
    private Integer goalsScored;
    private Integer goalsConceived;
    private Integer shots;
    private Integer passesCompleted;
    private Integer yellowCards;
    private Integer redCards;
    @OneToOne
    private Match match;
    @OneToOne
    private Team team;

    public HandballTeamStats(Team team, Match match) {
        this.team = team;
        this.match = match;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPossessionPercent() {
        return possessionPercent;
    }

    public void setPossessionPercent(Double possessionPercent) {
        this.possessionPercent = possessionPercent;
    }

    public Integer getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(Integer goalsScored) {
        this.goalsScored = goalsScored;
    }

    public Integer getGoalsConceived() {
        return goalsConceived;
    }

    public void setGoalsConceived(Integer goalsConceived) {
        this.goalsConceived = goalsConceived;
    }

    public Integer getShots() {
        return shots;
    }

    public void setShots(Integer shots) {
        this.shots = shots;
    }

    public Integer getPassesCompleted() {
        return passesCompleted;
    }

    public void setPassesCompleted(Integer passesCompleted) {
        this.passesCompleted = passesCompleted;
    }

    public Integer getYellowCards() {
        return yellowCards;
    }

    public void setYellowCards(Integer yellowCards) {
        this.yellowCards = yellowCards;
    }

    public Integer getRedCards() {
        return redCards;
    }

    public void setRedCards(Integer redCards) {
        this.redCards = redCards;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "FootballTeamStats{" +
                "id=" + id +
                ", possessionPercent=" + possessionPercent +
                ", goalsScored=" + goalsScored +
                ", goalsConceived=" + goalsConceived +
                ", shots=" + shots +
                ", passesCompleted=" + passesCompleted +
                ", yellowCards=" + yellowCards +
                ", redCards=" + redCards +
                ", match=" + match +
                ", team=" + team +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        HandballTeamStats that = (HandballTeamStats) o;
        return Objects.equals(id, that.id) && Objects.equals(possessionPercent, that.possessionPercent) && Objects.equals(goalsScored, that.goalsScored) && Objects.equals(goalsConceived, that.goalsConceived) && Objects.equals(shots, that.shots) && Objects.equals(passesCompleted, that.passesCompleted) && Objects.equals(yellowCards, that.yellowCards) && Objects.equals(redCards, that.redCards) && Objects.equals(match, that.match) && Objects.equals(team, that.team);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, possessionPercent, goalsScored, goalsConceived, shots, passesCompleted, yellowCards, redCards, match, team);
    }
}
