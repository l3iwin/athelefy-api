package com.athelefy.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class EventsDTO implements Serializable {

    private Long id;
    private String type;
    private String title;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private String location;
    private TeamDTO teamDTO;

    public EventsDTO(Long id, String type, String title, LocalDateTime startDateTime, LocalDateTime endDateTime, String location, TeamDTO teamDTO) {
        this.id = id;
        this.type = type;
        this.title = title;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.location = location;
        this.teamDTO = teamDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public TeamDTO getTeam() {
        return teamDTO;
    }

    public void setTeam(TeamDTO teamDTO) {
        this.teamDTO = teamDTO;
    }

    @Override
    public String toString() {
        return "Events{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", startDateTime=" + startDateTime +
                ", endDateTime=" + endDateTime +
                ", location='" + location + '\'' +
                ", team=" + teamDTO +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        EventsDTO eventsDTO = (EventsDTO) o;
        return Objects.equals(id, eventsDTO.id) && Objects.equals(type, eventsDTO.type) && Objects.equals(title, eventsDTO.title) && Objects.equals(startDateTime, eventsDTO.startDateTime) && Objects.equals(endDateTime, eventsDTO.endDateTime) && Objects.equals(location, eventsDTO.location) && Objects.equals(teamDTO, eventsDTO.teamDTO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, title, startDateTime, endDateTime, location, teamDTO);
    }
}
