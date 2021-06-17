package com.example.dao;

import com.example.entity.Aka;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AkaDao extends JpaRepository<Aka, String> {

    @Query(value = "with tmp as (select tconst from title where tconst = ?1)\n" +
            "select title, region, language from tmp natural join akas", nativeQuery = true)
    List<Aka> findAkaByTconst(String tconst);
}
