package com.example.dao;

import com.example.entity.Genre;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GenreDao extends JpaRepository<Genre, String> {
    @Query(value = "select genres.* from title_genres natural join genres where tconst = ?1",
            nativeQuery = true)
    List<Genre> findByRelativeTitle(String tconst);
}
