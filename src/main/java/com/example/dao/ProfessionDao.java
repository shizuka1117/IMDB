package com.example.dao;

import com.example.entity.Profession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProfessionDao extends JpaRepository<Profession, String> {

    @Query(value = "select profession.* from name natural join name_pro natural join profession where nconst = %?1%", nativeQuery = true)
    List<Profession> findProfessionByName();
}
