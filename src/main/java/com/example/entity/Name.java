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
    Integer birthYear;
    @Column(name="death_year")
    Integer deathYear;
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

    public String getBirthYear() {
        if(birthYear!=0)
            return birthYear.toString();
        else
            return "未知";
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public String getDeathYear() {
        if(deathYear!=0)
            return deathYear.toString();
        else
            return "未知";
    }

    public void setDeathYear(int deathYear) {
        this.deathYear = deathYear;
    }
}
