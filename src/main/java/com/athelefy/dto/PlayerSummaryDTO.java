package com.athelefy.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class PlayerSummaryDTO implements Serializable {
    private Long id;
    private String fullName;
    private String position;
    private String shirtNumber;
    private String federationNumber;
    private String weight;
    private String height;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateBirth;
    private String nationality;

    public PlayerSummaryDTO() {}

    public PlayerSummaryDTO(Long id, String fullName, String position, String shirtNumber, String federationNumber, String weight, String height, LocalDate dateBirth, String nationality) {
        this.id = id;
        this.fullName = fullName;
        this.position = position;
        this.shirtNumber = shirtNumber;
        this.federationNumber = federationNumber;
        this.weight = weight;
        this.height = height;
        this.dateBirth = dateBirth;
        this.nationality = nationality;
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

    public String getFederationNumber() {
        return federationNumber;
    }

    public void setFederationNumber(String federationNumber) {
        this.federationNumber = federationNumber;
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
        return "PlayerSummaryDTO{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", position='" + position + '\'' +
                ", shirtNumber='" + shirtNumber + '\'' +
                ", federationNumber='" + federationNumber + '\'' +
                ", weight='" + weight + '\'' +
                ", height='" + height + '\'' +
                ", dateBirth=" + dateBirth +
                ", nationality='" + nationality + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PlayerSummaryDTO that = (PlayerSummaryDTO) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
