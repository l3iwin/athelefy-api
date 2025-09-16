package com.athelefy.entity.event;

import com.athelefy.entity.Match;
import com.athelefy.entity.Player;
import com.athelefy.entity.Team;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Event implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Enumerated(EnumType.STRING)
    private EventType eventType;
    private int minute;
    private int second;
    private short x;
    private short y;
    private short endX;
    private short endY;
    @Enumerated(EnumType.STRING)
    private EventOutcome outcome;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "match_id", nullable = false)
    private Match match;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id", nullable = false)
    private Team team;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id")
    private Player player;

    public enum EventType {
        PASS, SHOT, FOUL, SAVE, DRIBBLE, TACKLE, OTHER
    }

    public enum EventOutcome {
        SUCCESS, FAIL, BLOCKED, GOAL, OTHER
    }

    public Event() {}

    public Event(Long id, EventType eventType, int minute, int second, short x, short y, short endX, short endY, EventOutcome outcome, Match match, Team team, Player player) {
        this.id = id;
        this.eventType = eventType;
        this.minute = minute;
        this.second = second;
        this.x = x;
        this.y = y;
        this.endX = endX;
        this.endY = endY;
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

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public short getX() {
        return x;
    }

    public void setX(short x) {
        this.x = x;
    }

    public short getY() {
        return y;
    }

    public void setY(short y) {
        this.y = y;
    }

    public short getEndX() {
        return endX;
    }

    public void setEndX(short endX) {
        this.endX = endX;
    }

    public short getEndY() {
        return endY;
    }

    public void setEndY(short endY) {
        this.endY = endY;
    }

    public EventOutcome getOutcome() {
        return outcome;
    }

    public void setOutcome(EventOutcome outcome) {
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
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", eventType=" + eventType +
                ", minute=" + minute +
                ", second=" + second +
                ", x=" + x +
                ", y=" + y +
                ", endX=" + endX +
                ", endY=" + endY +
                ", outcome=" + outcome +
                ", match=" + match +
                ", team=" + team +
                ", player=" + player +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return minute == event.minute && second == event.second && x == event.x && y == event.y && endX == event.endX && endY == event.endY && Objects.equals(id, event.id) && eventType == event.eventType && outcome == event.outcome && Objects.equals(match, event.match) && Objects.equals(team, event.team) && Objects.equals(player, event.player);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, eventType, minute, second, x, y, endX, endY, outcome, match, team, player);
    }
}
