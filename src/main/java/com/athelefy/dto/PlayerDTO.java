package com.athelefy.dto;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

public class PlayerDTO implements Serializable {

    private Long id;
    private String fullName;
    private String position;
    private String shirtNumber;
    private String federationNumber;
    private String weight;
    private String height;
    private UsersDTO usersDTO;
    Set<TeamDTO> teamDTOS;

    public PlayerDTO() {}

    public PlayerDTO(Long id, String fullName, String position, String shirtNumber, String federationNumber, String weight, String height, UsersDTO usersDTO, Set<TeamDTO> teamDTOS) {
        this.id = id;
        this.fullName = fullName;
        this.position = position;
        this.shirtNumber = shirtNumber;
        this.federationNumber = federationNumber;
        this.weight = weight;
        this.height = height;
        this.usersDTO = usersDTO;
        this.teamDTOS = teamDTOS;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getShirtNumber() {
        return shirtNumber;
    }

    public void setShirtNumber(String shirtNumber) {
        this.shirtNumber = shirtNumber;
    }

    public String getFederationNumber() {
        return federationNumber;
    }

    public void setFederationNumber(String federationNumber) {
        this.federationNumber = federationNumber;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public Set<TeamDTO> getTeamDTOS() {
        return teamDTOS;
    }

    public void setTeamDTOS(Set<TeamDTO> teamDTOS) {
        this.teamDTOS = teamDTOS;
    }

    @Override
    public String toString() {
        return "PlayerDTO{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", position='" + position + '\'' +
                ", shirtNumber='" + shirtNumber + '\'' +
                ", federationNumber='" + federationNumber + '\'' +
                ", weight='" + weight + '\'' +
                ", height='" + height + '\'' +
                '}';
    }
}
