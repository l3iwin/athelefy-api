package com.athelefy.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String position;
    private String shirtNumber;
    private String federationNumber;
    private String weight;
    private String height;
    private LocalDate dateBirth;
    private String nationality;
    @OneToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_user_player"))
    private Users users;
    @ManyToMany(mappedBy = "players")
    Set<Team> teams;

    public Player() {}

    public Player(Long id, String fullName, String position, String shirtNumber, String federationNumber, String weight, String height, LocalDate dateBirth, String nationality, Users users, Set<Team> teams) {
        this.id = id;
        this.fullName = fullName;
        this.position = position;
        this.shirtNumber = shirtNumber;
        this.federationNumber = federationNumber;
        this.weight = weight;
        this.height = height;
        this.dateBirth = dateBirth;
        this.nationality = nationality;
        this.users = users;
        this.teams = teams;
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

    public String getShirtNumber() {
        return shirtNumber;
    }

    public void setShirtNumber(String shirtNumber) {
        this.shirtNumber = shirtNumber;
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

    public Users getUser() {
        return users;
    }

    public void setUser(Users users) {
        this.users = users;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFederationNumber() {
        return federationNumber;
    }

    public void setFederationNumber(String federationNumber) {
        this.federationNumber = federationNumber;
    }

    public LocalDate getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(LocalDate dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", position='" + position + '\'' +
                ", shirtNumber='" + shirtNumber + '\'' +
                ", weight='" + weight + '\'' +
                ", height='" + height + '\'' +
                ", user=" + users +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(id, player.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
