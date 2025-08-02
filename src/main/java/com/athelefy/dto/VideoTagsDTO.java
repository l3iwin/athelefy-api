package com.athelefy.dto;

import java.io.Serializable;
import java.util.Objects;

public class VideoTagsDTO implements Serializable {

    private Long id;
    private String label;
    private String startTime;
    private String endTime;
    private PlayerDTO playerDTO;
    private VideoDTO videoDTO;

    public VideoTagsDTO(Long id, String label, String startTime, String endTime, PlayerDTO playerDTO, VideoDTO videoDTO) {
        this.id = id;
        this.label = label;
        this.startTime = startTime;
        this.endTime = endTime;
        this.playerDTO = playerDTO;
        this.videoDTO = videoDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public PlayerDTO getPlayer() {
        return playerDTO;
    }

    public void setPlayer(PlayerDTO playerDTO) {
        this.playerDTO = playerDTO;
    }

    public VideoDTO getVideo() {
        return videoDTO;
    }

    public void setVideo(VideoDTO videoDTO) {
        this.videoDTO = videoDTO;
    }

    @Override
    public String toString() {
        return "VideoTags{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", player=" + playerDTO +
                ", video=" + videoDTO +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        VideoTagsDTO videoTagsDTO = (VideoTagsDTO) o;
        return Objects.equals(id, videoTagsDTO.id) && Objects.equals(label, videoTagsDTO.label) && Objects.equals(startTime, videoTagsDTO.startTime) && Objects.equals(endTime, videoTagsDTO.endTime) && Objects.equals(playerDTO, videoTagsDTO.playerDTO) && Objects.equals(videoDTO, videoTagsDTO.videoDTO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, label, startTime, endTime, playerDTO, videoDTO);
    }
}
