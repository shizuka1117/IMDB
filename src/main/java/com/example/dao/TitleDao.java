package com.example.dao;

import com.example.entity.Title;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TitleDao extends JpaRepository<Title, String> {

    @Query(value = "select * from title where original_title = %?1%", nativeQuery = true)
    Page<Title> findByName(String original_title, Pageable pageable);
}
