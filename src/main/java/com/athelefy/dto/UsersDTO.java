package com.athelefy.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class UsersDTO implements Serializable {

    private Long id;
    private String fullName;
    private String email;
    private String password;
    private String role;
    private LocalDate dateBirth;

    public UsersDTO() {}

    public UsersDTO(Long id, String fullName, String email, String password, String role, LocalDate dateBirth) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.dateBirth = dateBirth;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDate getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(LocalDate dateBirth) {
        this.dateBirth = dateBirth;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", dateBirth=" + dateBirth +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UsersDTO usersDTO = (UsersDTO) o;
        return Objects.equals(id, usersDTO.id) && Objects.equals(fullName, usersDTO.fullName) && Objects.equals(email, usersDTO.email) && Objects.equals(password, usersDTO.password) && Objects.equals(role, usersDTO.role) && Objects.equals(dateBirth, usersDTO.dateBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, email, password, role, dateBirth);
    }
}
