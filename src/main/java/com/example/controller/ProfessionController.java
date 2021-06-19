package com.example.controller;

import com.example.common.Result;
import com.example.entity.Genre;
import com.example.entity.Profession;
import com.example.service.GenreService;
import com.example.service.ProfessionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/profession")
public class ProfessionController {
    @Resource
    ProfessionService professionService;

    @GetMapping("/{nconst}")
    public Result<List<Profession>> getProfessionsByRelativeName(@PathVariable String nconst){
        return Result.success(professionService.findByRelativeName(nconst));
    }
}
