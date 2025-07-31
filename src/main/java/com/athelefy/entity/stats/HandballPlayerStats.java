package com.athelefy.entity.stats;

import com.athelefy.entity.Match;
import com.athelefy.entity.Player;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class HandballPlayerStats implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer minutesPlayed;
    private Integer goals;
    private Integer passesCompleted;
    private Integer passesAttempted;
    private Integer shots;
    private Integer shotsOnTarget;
    private Integer foulsCommitted;
    private Integer foulsSuffered;
    private Integer twoMinutes;
    private Integer yellowCards;
    private Integer redCard;
    @OneToOne
    private Match match;
    @OneToOne
    private Player player;

    public HandballPlayerStats(Player player, Match match) {
        this.player = player;
        this.match = match;
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

    public Integer getTwoMinutes() {
        return twoMinutes;
    }

    public void setTwoMinutes(Integer twoMinutes) {
        this.twoMinutes = twoMinutes;
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

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public String toString() {
        return "FootballPlayerStats{" +
                "id=" + id +
                ", minutesPlayed=" + minutesPlayed +
                ", goals=" + goals +
                ", passesCompleted=" + passesCompleted +
                ", passesAttempted=" + passesAttempted +
                ", shots=" + shots +
                ", shotsOnTarget=" + shotsOnTarget +
                ", foulsCommitted=" + foulsCommitted +
                ", foulsSuffered=" + foulsSuffered +
                ", twoMinutes=" + twoMinutes +
                ", yellowCards=" + yellowCards +
                ", redCard=" + redCard +
                ", match=" + match +
                ", player=" + player +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        HandballPlayerStats that = (HandballPlayerStats) o;
        return Objects.equals(id, that.id) && Objects.equals(minutesPlayed, that.minutesPlayed) && Objects.equals(goals, that.goals) && Objects.equals(passesCompleted, that.passesCompleted) && Objects.equals(passesAttempted, that.passesAttempted) && Objects.equals(shots, that.shots) && Objects.equals(shotsOnTarget, that.shotsOnTarget) && Objects.equals(foulsCommitted, that.foulsCommitted) && Objects.equals(foulsSuffered, that.foulsSuffered) && Objects.equals(twoMinutes, that.twoMinutes) && Objects.equals(yellowCards, that.yellowCards) && Objects.equals(redCard, that.redCard) && Objects.equals(match, that.match) && Objects.equals(player, that.player);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, minutesPlayed, goals, passesCompleted, passesAttempted, shots, shotsOnTarget, foulsCommitted, foulsSuffered, twoMinutes, yellowCards, redCard, match, player);
    }
}
