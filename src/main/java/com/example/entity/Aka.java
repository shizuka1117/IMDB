package com.example.entity;

import org.springframework.context.annotation.Primary;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name="aka")
@Entity
public class Aka {
    @Id
    String tconst;
    int ordering;
    String title;
    String region;
    String languge;
    boolean isOriginalTitle;
    @ManyToOne(targetEntity = Title.class)
    Title oriTitle;

    public Title getOriTitle() {
        return oriTitle;
    }

    public void setOriTitle(Title oriTitle) {
        this.oriTitle = oriTitle;
    }

    public String getTconst() {
        return tconst;
    }

    public void setTconst(String tconst) {
        this.tconst = tconst;
    }

    public int getOrdering() {
        return ordering;
    }

    public void setOrdering(int ordering) {
        this.ordering = ordering;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getLanguge() {
        return languge;
    }

    public void setLanguge(String languge) {
        this.languge = languge;
    }

    public boolean isOriginalTitle() {
        return isOriginalTitle;
    }

    public void setOriginalTitle(boolean originalTitle) {
        isOriginalTitle = originalTitle;
    }
}
