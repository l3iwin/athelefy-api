package com.athelefy.dto;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

public class CoachDTO implements Serializable {

    private Long id;
    private CoachRoleDTO coachRoleDTO;
    private UsersDTO usersDTO;
    Set<TeamDTO> teamDTOS;

    public CoachDTO() {}

    public CoachDTO(Long id, CoachRoleDTO coachRoleDTO, UsersDTO usersDTO) {
        this.id = id;
        this.coachRoleDTO = coachRoleDTO;
        this.usersDTO = usersDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CoachRoleDTO getCoachRole() {
        return coachRoleDTO;
    }

    public void setCoachRole(CoachRoleDTO coachRoleDTO) {
        this.coachRoleDTO = coachRoleDTO;
    }

    public UsersDTO getUser() {
        return usersDTO;
    }

    public void setUser(UsersDTO usersDTO) {
        this.usersDTO = usersDTO;
    }

    @Override
    public String toString() {
        return "Coach{" +
                "id=" + id +
                ", coachRole=" + coachRoleDTO +
                ", user=" + usersDTO +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CoachDTO coachDTO = (CoachDTO) o;
        return Objects.equals(id, coachDTO.id) && Objects.equals(coachRoleDTO, coachDTO.coachRoleDTO) && Objects.equals(usersDTO, coachDTO.usersDTO) && Objects.equals(teamDTOS, coachDTO.teamDTOS);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, coachRoleDTO, usersDTO, teamDTOS);
    }
}
