package com.athelefy.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
public class Coach implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String role;
    @OneToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_user_coach"))
    private Users users;
    @ManyToMany(mappedBy = "coaches")
    Set<Team> teams;

    public Coach() {}

    public Coach(Long id, String role, Users users) {
        this.id = id;
        this.role = role;
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCoachRole() {
        return role;
    }

    public void setCoachRole(String role) {
        this.role = role;
    }

    public Users getUser() {
        return users;
    }

    public void setUser(Users users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Coach{" +
                "id=" + id +
                ", role=" + role +
                ", user=" + users +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Coach coach = (Coach) o;
        return Objects.equals(id, coach.id) && Objects.equals(role, coach.role) && Objects.equals(users, coach.users) && Objects.equals(teams, coach.teams);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, role, users, teams);
    }
}
