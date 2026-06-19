package com.athelefy.entity.stats.event;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class FootballEventPass implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Enumerated(EnumType.STRING)
    private PassType passType;
    @Enumerated(EnumType.STRING)
    private FieldThird third;
    private boolean keyPass;
    @Column(precision = 5)
    private Double expectedAssist;
    private boolean underPressure;
    @OneToOne(fetch = FetchType.LAZY)
    private Event event;

    public enum PassType {
        SHORT, LONG, CROSS
    }

    public enum FieldThird {
        DEFENSIVE, MIDDLE, OFFENSIVE
    }

    public FootballEventPass() {}

    public FootballEventPass(Long id, PassType passType, FieldThird third, boolean keyPass, Double expectedAssist, boolean underPressure, Event event) {
        this.id = id;
        this.passType = passType;
        this.third = third;
        this.keyPass = keyPass;
        this.expectedAssist = expectedAssist;
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

    public FieldThird getThird() {
        return third;
    }

    public void setThird(FieldThird third) {
        this.third = third;
    }

    public boolean isKeyPass() {
        return keyPass;
    }

    public void setKeyPass(boolean keyPass) {
        this.keyPass = keyPass;
    }

    public Double getExpectedAssist() {
        return expectedAssist;
    }

    public void setExpectedAssist(Double expectedAssist) {
        this.expectedAssist = expectedAssist;
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
        return "FootballEventPass{" +
                "id=" + id +
                ", passType=" + passType +
                ", third=" + third +
                ", keyPass=" + keyPass +
                ", expectedAssist=" + expectedAssist +
                ", underPressure=" + underPressure +
                ", event=" + event +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        FootballEventPass that = (FootballEventPass) o;
        return keyPass == that.keyPass && underPressure == that.underPressure && Objects.equals(id, that.id) && passType == that.passType && third == that.third && Objects.equals(expectedAssist, that.expectedAssist) && Objects.equals(event, that.event);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, passType, third, keyPass, expectedAssist, underPressure, event);
    }
}
