package com.example.dao;

import com.example.entity.Name;
import com.example.entity.Profession;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NameDao extends JpaRepository<Name, String> {

    @Query(value = "select name.* from title_name natural join name where tconst = ?1", nativeQuery = true)
    Page<Name> findNameByTitle(String tconst, Pageable pageable);

    @Query(value = "select * from name where primary_name like %?1%", nativeQuery = true)
    Page<Name> findNameByPrimaryName(String primaryName, Pageable pageable);

    @Query(value = "select * from name where nconst = ?1 ", nativeQuery = true)
    Name findNameByNconst(String nconst);
}
