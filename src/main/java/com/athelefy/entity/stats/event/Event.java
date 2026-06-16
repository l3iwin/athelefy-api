package com.athelefy.entity.stats.event;

import com.athelefy.entity.Match;
import com.athelefy.entity.Player;
import com.athelefy.entity.Team;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Event implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String eventType;
    private Long minute;
    private Long second;
    private String outcome;
    @ManyToOne
    private Match match;
    @ManyToOne
    private Team team;
    @ManyToOne
    private Player player;

    public Event() {}

    public Event(Long id, String eventType, Long minute, Long second, String outcome, Match match, Team team, Player player) {
        this.id = id;
        this.eventType = eventType;
        this.minute = minute;
        this.second = second;
        this.outcome = outcome;
        this.match = match;
        this.team = team;
        this.player = player;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public Long getMinute() {
        return minute;
    }

    public void setMinute(Long minute) {
        this.minute = minute;
    }

    public Long getSecond() {
        return second;
    }

    public void setSecond(Long second) {
        this.second = second;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
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

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(id, event.id) && Objects.equals(eventType, event.eventType) && Objects.equals(minute, event.minute) && Objects.equals(second, event.second) && Objects.equals(outcome, event.outcome) && Objects.equals(match, event.match) && Objects.equals(team, event.team) && Objects.equals(player, event.player);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, eventType, minute, second, outcome, match, team, player);
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", eventType='" + eventType + '\'' +
                ", minute=" + minute +
                ", second=" + second +
                ", outcome='" + outcome + '\'' +
                ", match=" + match +
                ", team=" + team +
                ", player=" + player +
                '}';
    }
}
