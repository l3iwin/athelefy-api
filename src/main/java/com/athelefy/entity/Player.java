package com.athelefy.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
public class Player implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String position;
    private String number;
    private String weight;
    private String height;
    @OneToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_user_player"))
    private Users users;
    @ManyToMany(mappedBy = "players")
    Set<Team> teams;

    public Player() {}

    public Player(Long id, String position, String number, String weight, String height, Users users) {
        this.id = id;
        this.position = position;
        this.number = number;
        this.weight = weight;
        this.height = height;
        this.users = users;
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

    public Users getUser() {
        return users;
    }

    public void setUser(Users users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", position='" + position + '\'' +
                ", number='" + number + '\'' +
                ", weight='" + weight + '\'' +
                ", height='" + height + '\'' +
                ", user=" + users +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(id, player.id) && Objects.equals(position, player.position) && Objects.equals(number, player.number) && Objects.equals(weight, player.weight) && Objects.equals(height, player.height) && Objects.equals(users, player.users) && Objects.equals(teams, player.teams);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, position, number, weight, height, users, teams);
    }
}
