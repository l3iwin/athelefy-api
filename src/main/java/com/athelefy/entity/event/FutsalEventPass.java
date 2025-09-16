package com.athelefy.entity.event;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class FutsalEventPass implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Enumerated(EnumType.STRING)
    private PassType passType;
    private boolean keyPass;
    private boolean underPressure;
    @OneToOne(fetch = FetchType.LAZY)
    private Event event;

    public enum PassType {
        SHORT, LONG, CROSS
    }

    public enum FieldThird {
        DEFENSIVE, MIDDLE, OFFENSIVE
    }

    public FutsalEventPass() {}

    public FutsalEventPass(Long id, PassType passType, boolean keyPass, boolean underPressure, Event event) {
        this.id = id;
        this.passType = passType;
        this.keyPass = keyPass;
        this.underPressure = underPressure;
        this.event = event;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PassType getPassType() {
        return passType;
    }

    public void setPassType(PassType passType) {
        this.passType = passType;
    }

    public boolean isKeyPass() {
        return keyPass;
    }

    public void setKeyPass(boolean keyPass) {
        this.keyPass = keyPass;
    }

    public boolean isUnderPressure() {
        return underPressure;
    }

    public void setUnderPressure(boolean underPressure) {
        this.underPressure = underPressure;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "FutsalEventPass{" +
                "id=" + id +
                ", passType=" + passType +
                ", keyPass=" + keyPass +
                ", underPressure=" + underPressure +
                ", event=" + event +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        FutsalEventPass that = (FutsalEventPass) o;
        return keyPass == that.keyPass && underPressure == that.underPressure && Objects.equals(id, that.id) && passType == that.passType && Objects.equals(event, that.event);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, passType, keyPass, underPressure, event);
    }
}
