//package com.athelefy.entity;
//
//import jakarta.persistence.*;
//
//import java.io.Serializable;
//import java.time.LocalDateTime;
//import java.util.Objects;
//
//@Entity
//public class Events implements Serializable {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//    private String type;
//    private String title;
//    private LocalDateTime startDateTime;
//    private LocalDateTime endDateTime;
//    private String location;
//    @OneToOne
//    private Team team;
//
//    public Events(Long id, String type, String title, LocalDateTime startDateTime, LocalDateTime endDateTime, String location, Team team) {
//        this.id = id;
//        this.type = type;
//        this.title = title;
//        this.startDateTime = startDateTime;
//        this.endDateTime = endDateTime;
//        this.location = location;
//        this.team = team;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public LocalDateTime getStartDateTime() {
//        return startDateTime;
//    }
//
//    public void setStartDateTime(LocalDateTime startDateTime) {
//        this.startDateTime = startDateTime;
//    }
//
//    public LocalDateTime getEndDateTime() {
//        return endDateTime;
//    }
//
//    public void setEndDateTime(LocalDateTime endDateTime) {
//        this.endDateTime = endDateTime;
//    }
//
//    public String getLocation() {
//        return location;
//    }
//
//    public void setLocation(String location) {
//        this.location = location;
//    }
//
//    public Team getTeam() {
//        return team;
//    }
//
//    public void setTeam(Team team) {
//        this.team = team;
//    }
//
//    @Override
//    public String toString() {
//        return "Events{" +
//                "id=" + id +
//                ", type='" + type + '\'' +
//                ", title='" + title + '\'' +
//                ", startDateTime=" + startDateTime +
//                ", endDateTime=" + endDateTime +
//                ", location='" + location + '\'' +
//                ", team=" + team +
//                '}';
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (o == null || getClass() != o.getClass()) return false;
//        Events events = (Events) o;
//        return Objects.equals(id, events.id) && Objects.equals(type, events.type) && Objects.equals(title, events.title) && Objects.equals(startDateTime, events.startDateTime) && Objects.equals(endDateTime, events.endDateTime) && Objects.equals(location, events.location) && Objects.equals(team, events.team);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, type, title, startDateTime, endDateTime, location, team);
//    }
//}
