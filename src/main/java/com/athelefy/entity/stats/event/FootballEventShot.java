package com.athelefy.entity.stats.event;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class FootballEventShot implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Enumerated(EnumType.STRING)
    private BodyPart bodyPart;
    @Enumerated(EnumType.STRING)
    private Situation situation;
    private boolean wasGoal;
    @OneToOne(fetch = FetchType.LAZY)
    private Event event;

    public enum BodyPart {
        FOOT, HEAD, OTHER
    }

    public enum Situation {
        OPEN_PLAY, SET_PIECE, PENALTY
    }

    public FootballEventShot() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BodyPart getBodyPart() {
        return bodyPart;
    }

    public void setBodyPart(BodyPart bodyPart) {
        this.bodyPart = bodyPart;
    }

    public Situation getSituation() {
        return situation;
    }

    public void setSituation(Situation situation) {
        this.situation = situation;
    }

    public boolean isWasGoal() {
        return wasGoal;
    }

    public void setWasGoal(boolean wasGoal) {
        this.wasGoal = wasGoal;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "FootballEventShot{" +
                "id=" + id +
                ", bodyPart=" + bodyPart +
                ", situation=" + situation +
                ", wasGoal=" + wasGoal +
                ", event=" + event +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        FootballEventShot that = (FootballEventShot) o;
        return wasGoal == that.wasGoal && Objects.equals(id, that.id) && bodyPart == that.bodyPart && situation == that.situation && Objects.equals(event, that.event);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bodyPart, situation, wasGoal, event);
    }
}
