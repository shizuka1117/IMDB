package com.example.controller;

import com.example.common.Result;
import com.example.entity.Rating;
import com.example.service.RatingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/rating")
public class RatingController {
    @Resource
    RatingService ratingService;

    @GetMapping("")
    public Result<Rating> getRatingByRelativeTitle(String tconst){
        return Result.success(ratingService.findByTconst(tconst));
    }
}
