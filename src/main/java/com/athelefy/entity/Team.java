package com.athelefy.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
public class Team implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String category;
    @ManyToOne
    private Club club;
    @ManyToOne
    private Sport sport;
    @ManyToMany
    @JoinTable(name = "player_teams", joinColumns = @JoinColumn(name = "team_id"), inverseJoinColumns = @JoinColumn(name = "player_id"))
    Set<Player> players;
    @ManyToMany
    @JoinTable(name = "coaches_teams", joinColumns = @JoinColumn(name = "team_id"), inverseJoinColumns = @JoinColumn(name = "coach_id"))
    Set<Coach> coaches;

    public Team(Long id, String name, String category, Club club, Sport sport) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.club = club;
        this.sport = sport;
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

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", club=" + club +
                ", sport=" + sport +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(id, team.id) && Objects.equals(name, team.name) && Objects.equals(category, team.category) && Objects.equals(club, team.club) && Objects.equals(sport, team.sport) && Objects.equals(players, team.players) && Objects.equals(coaches, team.coaches);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, category, club, sport, players, coaches);
    }
}
