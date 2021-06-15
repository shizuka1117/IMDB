package com.example.dao;

import com.example.entity.Title;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TitleDao extends JpaRepository<Title, String> {

    @Query(value = "select * from title where original_title = %?1%", nativeQuery = true)
    Page<Title> findByOriginalTitle(String original_title, Pageable pageable);

    @Query(value = "with tmp as (select * from name where nconst = %?1%)\n" +
            "select title.* from tmp natural join title_name natural join title", nativeQuery = true)
    List<Title> findByName(String nconst);
}
