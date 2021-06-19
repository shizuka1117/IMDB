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

    @Query(value = "select * from title where original_title like %?1%", nativeQuery = true)
    Page<Title> findByOriginalTitle(String original_title, Pageable pageable);

    @Query(value = "select * from title where original_title like %?1% and type = ?2", nativeQuery = true)
    Page<Title> findByOriginalTitle(String original_title, String type, Pageable pageable);

    @Query(value = "select title.* from title_name natural join title where title_name.nconst = ?1", nativeQuery = true)
    Page<Title> findByName(String nconst, Pageable pageable);

    @Query(value = "select * from title where type = ?1 ", nativeQuery = true)
    Page<Title> findByType(String type, Pageable pageable);

    @Query(value = "select * from title where tconst = ?1 ", nativeQuery = true)
    Title findByTconst(String tconst);
}
