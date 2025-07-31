package com.athelefy.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import java.util.Set;

@Entity
public class Video implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String url;
    private Instant createdAt;
    @ManyToOne
    private Match match;
    @OneToOne
    private Users uploadedBy;
    @OneToMany(mappedBy = "video")
    private Set<VideoTags> videoTags;

    public Video(String url, Instant createdAt, Match match, Users uploadedBy) {
        this.url = url;
        this.createdAt = createdAt;
        this.match = match;
        this.uploadedBy = uploadedBy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public Users getUploadedBy() {
        return uploadedBy;
    }

    public void setUploadedBy(Users uploadedBy) {
        this.uploadedBy = uploadedBy;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", createdAt=" + createdAt +
                ", match=" + match +
                ", uploadedBy=" + uploadedBy +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Video video = (Video) o;
        return Objects.equals(id, video.id) && Objects.equals(url, video.url) && Objects.equals(createdAt, video.createdAt) && Objects.equals(match, video.match) && Objects.equals(uploadedBy, video.uploadedBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, url, createdAt, match, uploadedBy);
    }
}
