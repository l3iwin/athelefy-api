package com.athelefy.dto.stats;

import com.athelefy.dto.MatchDTO;
import com.athelefy.dto.PlayerDTO;

import java.io.Serializable;
import java.util.Objects;

public class FootballPlayerStatsDTO implements Serializable {

    private Long id;
    private Integer minutesPlayed;
    private Integer goals;
    private Integer assists;
    private Integer passesCompleted;
    private Integer passesAttempted;
    private Integer shots;
    private Integer shotsOnTarget;
    private Integer foulsCommitted;
    private Integer foulsSuffered;
    private Integer yellowCards;
    private Integer redCard;
    private MatchDTO matchDTO;
    private PlayerDTO playerDTO;

    public FootballPlayerStatsDTO(PlayerDTO playerDTO, MatchDTO matchDTO) {
        this.playerDTO = playerDTO;
        this.matchDTO = matchDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMinutesPlayed() {
        return minutesPlayed;
    }

    public void setMinutesPlayed(Integer minutesPlayed) {
        this.minutesPlayed = minutesPlayed;
    }

    public Integer getGoals() {
        return goals;
    }

    public void setGoals(Integer goals) {
        this.goals = goals;
    }

    public Integer getAssists() {
        return assists;
    }

    public void setAssists(Integer assists) {
        this.assists = assists;
    }

    public Integer getPassesCompleted() {
        return passesCompleted;
    }

    public void setPassesCompleted(Integer passesCompleted) {
        this.passesCompleted = passesCompleted;
    }

    public Integer getPassesAttempted() {
        return passesAttempted;
    }

    public void setPassesAttempted(Integer passesAttempted) {
        this.passesAttempted = passesAttempted;
    }

    public Integer getShots() {
        return shots;
    }

    public void setShots(Integer shots) {
        this.shots = shots;
    }

    public Integer getShotsOnTarget() {
        return shotsOnTarget;
    }

    public void setShotsOnTarget(Integer shotsOnTarget) {
        this.shotsOnTarget = shotsOnTarget;
    }

    public Integer getFoulsCommitted() {
        return foulsCommitted;
    }

    public void setFoulsCommitted(Integer foulsCommitted) {
        this.foulsCommitted = foulsCommitted;
    }

    public Integer getFoulsSuffered() {
        return foulsSuffered;
    }

    public void setFoulsSuffered(Integer foulsSuffered) {
        this.foulsSuffered = foulsSuffered;
    }

    public Integer getYellowCards() {
        return yellowCards;
    }

    public void setYellowCards(Integer yellowCards) {
        this.yellowCards = yellowCards;
    }

    public Integer getRedCard() {
        return redCard;
    }

    public void setRedCard(Integer redCard) {
        this.redCard = redCard;
    }

    public MatchDTO getMatch() {
        return matchDTO;
    }

    public void setMatch(MatchDTO matchDTO) {
        this.matchDTO = matchDTO;
    }

    public PlayerDTO getPlayer() {
        return playerDTO;
    }

    public void setPlayer(PlayerDTO playerDTO) {
        this.playerDTO = playerDTO;
    }

    @Override
    public String toString() {
        return "FootballPlayerStats{" +
                "id=" + id +
                ", minutesPlayed=" + minutesPlayed +
                ", goals=" + goals +
                ", assists=" + assists +
                ", passesCompleted=" + passesCompleted +
                ", passesAttempted=" + passesAttempted +
                ", shots=" + shots +
                ", shotsOnTarget=" + shotsOnTarget +
                ", foulsCommitted=" + foulsCommitted +
                ", foulsSuffered=" + foulsSuffered +
                ", yellowCards=" + yellowCards +
                ", redCard=" + redCard +
                ", match=" + matchDTO +
                ", player=" + playerDTO +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        FootballPlayerStatsDTO that = (FootballPlayerStatsDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(minutesPlayed, that.minutesPlayed) && Objects.equals(goals, that.goals) && Objects.equals(assists, that.assists) && Objects.equals(passesCompleted, that.passesCompleted) && Objects.equals(passesAttempted, that.passesAttempted) && Objects.equals(shots, that.shots) && Objects.equals(shotsOnTarget, that.shotsOnTarget) && Objects.equals(foulsCommitted, that.foulsCommitted) && Objects.equals(foulsSuffered, that.foulsSuffered) && Objects.equals(yellowCards, that.yellowCards) && Objects.equals(redCard, that.redCard) && Objects.equals(matchDTO, that.matchDTO) && Objects.equals(playerDTO, that.playerDTO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, minutesPlayed, goals, assists, passesCompleted, passesAttempted, shots, shotsOnTarget, foulsCommitted, foulsSuffered, yellowCards, redCard, matchDTO, playerDTO);
    }
}
