package com.athelefy.dto;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

public class TeamDTO implements Serializable {

    private Long id;
    private String name;
    private String category;
    private ClubDTO clubDto;
    private SportDTO sportDTO;
    Set<PlayerDTO> playerDTOS;
    Set<CoachDTO> coachDTOS;

    public TeamDTO(Long id, String name, String category, ClubDTO clubDto, SportDTO sportDTO) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.clubDto = clubDto;
        this.sportDTO = sportDTO;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public ClubDTO getClub() {
        return clubDto;
    }

    public void setClub(ClubDTO clubDto) {
        this.clubDto = clubDto;
    }

    public SportDTO getSport() {
        return sportDTO;
    }

    public void setSport(SportDTO sportDTO) {
        this.sportDTO = sportDTO;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", club=" + clubDto +
                ", sport=" + sportDTO +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TeamDTO teamDTO = (TeamDTO) o;
        return Objects.equals(id, teamDTO.id) && Objects.equals(name, teamDTO.name) && Objects.equals(category, teamDTO.category) && Objects.equals(clubDto, teamDTO.clubDto) && Objects.equals(sportDTO, teamDTO.sportDTO) && Objects.equals(playerDTOS, teamDTO.playerDTOS) && Objects.equals(coachDTOS, teamDTO.coachDTOS);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, category, clubDto, sportDTO, playerDTOS, coachDTOS);
    }
}
