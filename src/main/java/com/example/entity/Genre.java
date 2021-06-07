package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Table(name="genre")
@Entity
public class Genre {
    @Id
    String gconst;
    String gname;
    @ManyToMany(targetEntity = Title.class)
    Set<Title> titles = new HashSet<Title>();

    public String getGconst() {
        return gconst;
    }

    public void setGconst(String gconst) {
        this.gconst = gconst;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }
}
