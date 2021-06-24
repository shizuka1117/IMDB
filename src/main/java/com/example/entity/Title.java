package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.text.DecimalFormat;

import static java.lang.StrictMath.floor;

@Table(name="new_title")
@Entity
public class Title {
    @Id
    private String tconst;
    private String type;
    private String original_title;
    private boolean is_adult;
    private Integer start_year;
    private Integer end_year;
    private Integer runtime_minutes;
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

    public String getStart_year() {
        if(start_year==0)
            return "未知";
        else
            return start_year.toString();
    }

    public void setStart_year(int start_year) {
        this.start_year = start_year;
    }

    public String getEnd_year() {
        if(end_year==0)
            return "未知";
        else
            return end_year.toString();
    }

    public void setEnd_year(int end_year) {
        this.end_year = end_year;
    }

    public String getRuntime_minutes() {
        if(runtime_minutes==0)
            return "未知";
        else
            return runtime_minutes.toString();
    }

    public void setRuntime_minutes(int runtime_minutes) {
        this.runtime_minutes = runtime_minutes;
    }

    public String getAverage_rating() {
        DecimalFormat df2 = new DecimalFormat("#.0");
        if(average_rating!=null)
            return df2.format(average_rating.doubleValue());
        else
            return "未知";
    }

    public void setAverage_rating(Double average_rating) {
        this.average_rating = average_rating;
    }

    public Integer getNum_votes() {
        return num_votes;
    }

    public void setNum_votes(Integer num_votes) {
        this.num_votes = num_votes;
    }
}
