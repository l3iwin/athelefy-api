package com.athelefy.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class VideoTags implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String label;
    private String startTime;
    private String endTime;
    @OneToOne
    private Player player;
    @ManyToOne
    private Video video;

    public VideoTags(Long id, String label, String startTime, String endTime, Player player, Video video) {
        this.id = id;
        this.label = label;
        this.startTime = startTime;
        this.endTime = endTime;
        this.player = player;
        this.video = video;
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

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    @Override
    public String toString() {
        return "VideoTags{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", player=" + player +
                ", video=" + video +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        VideoTags videoTags = (VideoTags) o;
        return Objects.equals(id, videoTags.id) && Objects.equals(label, videoTags.label) && Objects.equals(startTime, videoTags.startTime) && Objects.equals(endTime, videoTags.endTime) && Objects.equals(player, videoTags.player) && Objects.equals(video, videoTags.video);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, label, startTime, endTime, player, video);
    }
}
