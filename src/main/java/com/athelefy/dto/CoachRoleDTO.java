package com.athelefy.dto;

import java.io.Serializable;
import java.util.Objects;

public class CoachRoleDTO implements Serializable {

    private Long id;
    private String role;

    public CoachRoleDTO() {}

    public CoachRoleDTO(Long id, String role) {
        this.id = id;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "CoachRole{" +
                "id=" + id +
                ", role='" + role + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CoachRoleDTO coachRoleDTO = (CoachRoleDTO) o;
        return Objects.equals(id, coachRoleDTO.id) && Objects.equals(role, coachRoleDTO.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, role);
    }
}
