package com.example.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(name="title")
@Entity
public class Title {

    @Id
    private String tconst;
    private String type;
    private String original_title;
    private boolean is_adult;
    private int start_year;
    private int end_year;
    private int runtime_minutes;
    @OneToOne(targetEntity = Rating.class, fetch = FetchType.LAZY)
    private Rating rating;
    @OneToMany(targetEntity = Aka.class, fetch = FetchType.LAZY)
    @JoinColumn(name="tconst")
    private Set<Aka> akas = new HashSet<Aka>();
    @ManyToMany(targetEntity = Genre.class, fetch = FetchType.LAZY)
    private Set<Genre> genres = new HashSet<Genre>();
    @ManyToMany(targetEntity = Name.class, fetch = FetchType.LAZY)
    private Set<Name> names = new HashSet<Name>();

    public String getTconst() {
        return tconst;
    }

    public void setTconst(String tconst) {
        this.tconst = tconst;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isIs_adult() {
        return is_adult;
    }

    public void setIs_adult(boolean is_adult) {
        this.is_adult = is_adult;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public int getStart_year() {
        return start_year;
    }

    public void setStart_year(int start_year) {
        this.start_year = start_year;
    }

    public int getEnd_year() {
        return end_year;
    }

    public void setEnd_year(int end_year) {
        this.end_year = end_year;
    }

    public int getRuntime_minutes() {
        return runtime_minutes;
    }

    public void setRuntime_minutes(int runtime_minutes) {
        this.runtime_minutes = runtime_minutes;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public Set<Aka> getAkas() {
        return akas;
    }

    public void setAkas(Set<Aka> akas) {
        this.akas = akas;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }
}
