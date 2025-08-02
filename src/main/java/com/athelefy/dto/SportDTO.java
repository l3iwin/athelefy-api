package com.athelefy.dto;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

public class SportDTO implements Serializable {

    private Long id;
    private String name;
    private Set<TeamDTO> teamDTO;

    public SportDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Sports{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SportDTO sportDTO = (SportDTO) o;
        return Objects.equals(id, sportDTO.id) && Objects.equals(name, sportDTO.name) && Objects.equals(teamDTO, sportDTO.teamDTO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, teamDTO);
    }
}
