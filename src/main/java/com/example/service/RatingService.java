package com.example.service;

import com.example.dao.RatingDao;
import com.example.entity.Rating;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RatingService {
    @Resource
    RatingDao ratingDao;

    public Rating findByTconst(String tconst){
        return ratingDao.findById(tconst).orElse(null);
    }
}
