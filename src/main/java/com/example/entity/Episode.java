package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="episode")
@Entity
public class Episode {
    @Id
    String tconst;
    @Column(name = "parent_tconst")
    String parentTconst;
    @Column(name = "season_number")
    int seasonNumber;
    @Column(name = "episode_number")
    int episodeNumber;

    public String getTconst() {
        return tconst;
    }

    public void setTconst(String tconst) {
        this.tconst = tconst;
    }

    public String getParentTconst() {
        return parentTconst;
    }

    public void setParentTconst(String parentTconst) {
        this.parentTconst = parentTconst;
    }

    public int getSeasonNumber() {
        return seasonNumber;
    }

    public void setSeasonNumber(int seasonNumber) {
        this.seasonNumber = seasonNumber;
    }

    public int getEpisodeNumber() {
        return episodeNumber;
    }

    public void setEpisodeNumber(int episodeNumber) {
        this.episodeNumber = episodeNumber;
    }
}

