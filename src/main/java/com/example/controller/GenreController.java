package com.example.controller;

import com.example.common.Result;
import com.example.entity.Genre;
import com.example.service.GenreService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/genre")
public class GenreController {
    @Resource
    GenreService genreService;

    @GetMapping("/{tconst}")
    public Result<List<Genre>> getGenresByRelativeTitle(@PathVariable String tconst,
                                                   @RequestParam(defaultValue = "1") Integer pageNum,
                                                   @RequestParam(defaultValue = "10") Integer pageSize){
        return Result.success(genreService.findByRelativeTitle(tconst, pageNum, pageSize));
    }
}
