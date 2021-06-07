package com.example.controller;

import com.example.common.Result;
import com.example.entity.Title;
import com.example.service.TitleService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/title")
public class TitleController {
    @Resource
    private TitleService titleService;

    @PostMapping
    public Result add(@RequestBody Title title){
        titleService.save(title);
        return Result.success();
    }

    @PostMapping("/{tconst}")
    public Result update(@RequestBody Title title){
        titleService.save(title);
        return Result.success();
    }

    @DeleteMapping("/{tconst}")
    public Result delete(@PathVariable String tconst){
        titleService.del(tconst);
        return Result.success();
    }

    @GetMapping("/{tconst}")
    public Result findByTconst(@PathVariable String tconst){
        return Result.success(titleService.findByTconst(tconst));
    }

    @GetMapping("/page")
    public Result<Page<Title>> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                                            @RequestParam(defaultValue = "10") Integer pageSize
                                            ){
        return Result.success(titleService.findPage(pageNum, pageSize));
    }
}
