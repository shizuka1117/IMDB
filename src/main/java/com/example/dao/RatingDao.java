package com.example.dao;

import com.example.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RatingDao extends JpaRepository<Rating, String> {

    @Query(value = "select * from rating where tconst = ?1", nativeQuery = true)
    Rating findRatingByTconst(String tconst);

    //where num_votes > 10000 and average_rating >= 7 order by average_rating desc
    @Query(value = "select tconst from rating where num_votes > 10000 and average_rating >= 7 order by average_rating desc", nativeQuery = true)
    List<String> findBestRatings();
}
