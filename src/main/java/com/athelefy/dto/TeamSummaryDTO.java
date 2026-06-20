package com.athelefy.dto;

import java.io.Serializable;
import java.util.Set;

public class TeamSummaryDTO implements Serializable {

    private Long id;
    private String name;
    private String category;
    private String sport;
    public TeamSummaryDTO() {}

    public TeamSummaryDTO(Long id, String name, String category, String sport) {
        this.id = id;
        this.name = name;
        this.category = category;
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

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    @Override
    public String toString() {
        return "TeamDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", sport='" + sport + '\'' +
                '}';
    }
}
