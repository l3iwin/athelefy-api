package com.athelefy.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import java.util.Set;

public class VideoDTO implements Serializable {

    private Long id;
    private String url;
    private Instant createdAt;
    private MatchDTO matchDTO;
    private UsersDTO uploadedBy;
    private Set<VideoTagsDTO> videoTagDTOS;

    public VideoDTO(String url, Instant createdAt, MatchDTO matchDTO, UsersDTO uploadedBy) {
        this.url = url;
        this.createdAt = createdAt;
        this.matchDTO = matchDTO;
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

    public MatchDTO getMatch() {
        return matchDTO;
    }

    public void setMatch(MatchDTO matchDTO) {
        this.matchDTO = matchDTO;
    }

    public UsersDTO getUploadedBy() {
        return uploadedBy;
    }

    public void setUploadedBy(UsersDTO uploadedBy) {
        this.uploadedBy = uploadedBy;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", createdAt=" + createdAt +
                ", match=" + matchDTO +
                ", uploadedBy=" + uploadedBy +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        VideoDTO videoDTO = (VideoDTO) o;
        return Objects.equals(id, videoDTO.id) && Objects.equals(url, videoDTO.url) && Objects.equals(createdAt, videoDTO.createdAt) && Objects.equals(matchDTO, videoDTO.matchDTO) && Objects.equals(uploadedBy, videoDTO.uploadedBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, url, createdAt, matchDTO, uploadedBy);
    }
}
