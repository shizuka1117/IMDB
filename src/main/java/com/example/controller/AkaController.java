package com.example.controller;

import com.example.common.Result;
import com.example.entity.Aka;
import com.example.service.AkaService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/aka")
public class AkaController {
    @Resource
    private AkaService akaService;

    @GetMapping("/{tconst}")
    public Result<List<Aka>> getAkasByRelativeTitle(@PathVariable String tconst,
                                                 @RequestParam(defaultValue = "1") Integer pageNum,
                                                 @RequestParam(defaultValue = "10") Integer pageSize){
        return Result.success(akaService.findByRelativeTitle(tconst, pageNum, pageSize));
    }
}
