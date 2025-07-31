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
    @OneToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_role_coach"))
    private CoachRole coachRole;
    @OneToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_user_coach"))
    private Users users;
    @ManyToMany(mappedBy = "coaches")
    Set<Team> teams;

    public Coach() {}

    public Coach(Long id, CoachRole coachRole, Users users) {
        this.id = id;
        this.coachRole = coachRole;
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CoachRole getCoachRole() {
        return coachRole;
    }

    public void setCoachRole(CoachRole coachRole) {
        this.coachRole = coachRole;
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
                ", coachRole=" + coachRole +
                ", user=" + users +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Coach coach = (Coach) o;
        return Objects.equals(id, coach.id) && Objects.equals(coachRole, coach.coachRole) && Objects.equals(users, coach.users) && Objects.equals(teams, coach.teams);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, coachRole, users, teams);
    }
}
