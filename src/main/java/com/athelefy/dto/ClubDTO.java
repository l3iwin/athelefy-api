package com.athelefy.dto;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

public class ClubDTO implements Serializable {

    private Long id;
    private String name;
    private String country;
    private Set<TeamDTO> teamDTO;

    public ClubDTO(Long id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Clubs{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ClubDTO clubDto = (ClubDTO) o;
        return Objects.equals(id, clubDto.id) && Objects.equals(name, clubDto.name) && Objects.equals(country, clubDto.country) && Objects.equals(teamDTO, clubDto.teamDTO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, country, teamDTO);
    }
}
