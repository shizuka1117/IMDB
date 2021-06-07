package com.example.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(name="name")
@Entity
public class Name {
    @Id
    String nconst;
    @Column(name="primary_name")
    String primaryName;
    @Column(name="birth_year")
    int birthYear;
    @Column(name="death_year")
    int deathYear;
    @ManyToMany(targetEntity = Title.class, fetch = FetchType.LAZY)
    private Set<Title> titles = new HashSet<Title>();
    @ManyToMany(targetEntity = Profession.class, fetch = FetchType.LAZY)
    private Set<Profession> professions = new HashSet<Profession>();

    public String getNconst() {
        return nconst;
    }

    public void setNconst(String nconst) {
        this.nconst = nconst;
    }

    public String getPrimaryName() {
        return primaryName;
    }

    public void setPrimaryName(String primaryName) {
        this.primaryName = primaryName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public int getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(int deathYear) {
        this.deathYear = deathYear;
    }
}
