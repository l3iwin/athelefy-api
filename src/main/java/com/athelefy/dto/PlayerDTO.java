package com.athelefy.dto;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

public class PlayerDTO implements Serializable {

    private Long id;
    private String position;
    private String number;
    private String weight;
    private String height;
    private UsersDTO usersDTO;
    Set<TeamDTO> teamDTOS;

    public PlayerDTO() {}

    public PlayerDTO(Long id, String position, String number, String weight, String height, UsersDTO usersDTO) {
        this.id = id;
        this.position = position;
        this.number = number;
        this.weight = weight;
        this.height = height;
        this.usersDTO = usersDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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

    public UsersDTO getUser() {
        return usersDTO;
    }

    public void setUser(UsersDTO usersDTO) {
        this.usersDTO = usersDTO;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", position='" + position + '\'' +
                ", number='" + number + '\'' +
                ", weight='" + weight + '\'' +
                ", height='" + height + '\'' +
                ", user=" + usersDTO +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PlayerDTO playerDTO = (PlayerDTO) o;
        return Objects.equals(id, playerDTO.id) && Objects.equals(position, playerDTO.position) && Objects.equals(number, playerDTO.number) && Objects.equals(weight, playerDTO.weight) && Objects.equals(height, playerDTO.height) && Objects.equals(usersDTO, playerDTO.usersDTO) && Objects.equals(teamDTOS, playerDTO.teamDTOS);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, position, number, weight, height, usersDTO, teamDTOS);
    }
}
