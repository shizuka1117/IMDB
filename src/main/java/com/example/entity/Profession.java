package com.example.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(name="name")
@Entity
public class Profession {
    @Id
    String pconst;
    String pname;
    @ManyToMany(targetEntity = Name.class, fetch = FetchType.LAZY)
    private Set<Name> names = new HashSet<Name>();

    public String getPconst() {
        return pconst;
    }

    public void setPconst(String pconst) {
        this.pconst = pconst;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }
}
