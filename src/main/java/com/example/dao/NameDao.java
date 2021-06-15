package com.example.dao;

import com.example.entity.Name;
import com.example.entity.Profession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NameDao extends JpaRepository<Name, String> {

    @Query(value = "select name.* from title natural join title_name natural join name where tconst = %?1%", nativeQuery = true)
    List<Name> findNameByTitle(String tconst);

    @Query(value = "select * from name where primary_name = %?1%", nativeQuery = true)
    List<Name> findNameByPrimaryName(String primaryName);
}
