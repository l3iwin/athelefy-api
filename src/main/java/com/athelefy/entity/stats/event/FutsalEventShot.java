package com.athelefy.entity.stats.event;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class FutsalEventShot implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Event event;
    private String bodyPart;
    private String situation;

    public FutsalEventShot() {}

    public FutsalEventShot(Long id, Event event, String bodyPart, String situation) {
        this.id = id;
        this.event = event;
        this.bodyPart = bodyPart;
        this.situation = situation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public String getBodyPart() {
        return bodyPart;
    }

    public void setBodyPart(String bodyPart) {
        this.bodyPart = bodyPart;
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        FutsalEventShot that = (FutsalEventShot) o;
        return Objects.equals(id, that.id) && Objects.equals(event, that.event) && Objects.equals(bodyPart, that.bodyPart) && Objects.equals(situation, that.situation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, event, bodyPart, situation);
    }

    @Override
    public String toString() {
        return "FootballEventShot{" +
                "id=" + id +
                ", event=" + event +
                ", bodyPart='" + bodyPart + '\'' +
                ", situation='" + situation + '\'' +
                '}';
    }
}
