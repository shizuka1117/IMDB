package com.example.entity;

import javax.persistence.*;

@Table(name="rating")
@Entity
public class Rating {
    @Id
    String tconst;
    @Column(name = "average_rating")
    double averageRating;
    @Column(name = "num_votes")
    int numVotes;
    @OneToOne(targetEntity = Title.class)
    Title title;

    public String getTconst() {
        return tconst;
    }

    public void setTconst(String tconst) {
        this.tconst = tconst;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public int getNumVotes() {
        return numVotes;
    }

    public void setNumVotes(int numVotes) {
        this.numVotes = numVotes;
    }
}
