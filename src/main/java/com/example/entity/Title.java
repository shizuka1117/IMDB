package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="new_title")
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
    private Double average_rating;
    private Integer num_votes = 0;

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

    public Double getAverage_rating() {
        return average_rating;
    }

    public void setAverage_rating(Double average_rating) {
        if(average_rating!=null)
            this.average_rating = 0.0;

        else
            this.average_rating = average_rating;
    }

    public Integer getNum_votes() {
        return num_votes;
    }

    public void setNum_votes(Integer num_votes) {
        if(num_votes!=null)
            this.num_votes = 0;
        else
            this.num_votes = num_votes;
    }
}
