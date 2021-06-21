package com.example.dao;

import com.example.entity.Title;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TitleDao extends JpaRepository<Title, String> {

    @Query(value = "select * from new_title where original_title like %?1%", nativeQuery = true)
    Page<Title> findByOriginalTitle(String original_title, Pageable pageable);

    @Query(value = "select * from new_title where original_title like %?1% and type = ?2", nativeQuery = true)
    Page<Title> findByOriginalTitle(String original_title, String type, Pageable pageable);

    @Query(value = "select new_title.* from title_name natural join new_title where title_name.nconst = ?1", nativeQuery = true)
    Page<Title> findByName(String nconst, Pageable pageable);

    @Query(value = "select * from new_title where type = ?1 ", nativeQuery = true)
    Page<Title> findByType(String type, Pageable pageable);

    @Query(value = "select * from new_title where tconst = ?1 ", nativeQuery = true)
    Title findByTconst(String tconst);

    @Query(value = "select * from new_title where average_rating >= 7 and num_votes >= 10000 order by average_rating", nativeQuery = true)
    Page<Title> findBestTitles(Pageable pageable);

    @Query(value = "select * from new_title where average_rating >= 7 and num_votes >= 10000 and type = ?1 order by average_rating", nativeQuery = true)
    Page<Title> findBestTitlesWithType(String type, Pageable pageable);
}
