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

    /*@PostMapping
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
    }*/

    @GetMapping("/{tconst}")
    public Result<Page<Title>> getTitleByTconst(@PathVariable String tconst,
                                                @RequestParam(defaultValue = "1") Integer pageNum,
                                                @RequestParam(defaultValue = "10") Integer pageSize
    ){
        return Result.success(titleService.findByTconst(tconst, pageNum, pageSize));
    }

    @GetMapping("/originalTitle")
    public Result<Page<Title>> getTitleByOriginalTitle(@RequestParam(defaultValue = "") String originalTitle,
                                                       @RequestParam(defaultValue = "1") Integer pageNum,
                                                       @RequestParam(defaultValue = "10") Integer pageSize){
        return Result.success(titleService.findByOriginalTitle(originalTitle, pageNum, pageSize));
    }

    @GetMapping("/page")
    public Result<Page<Title>> getTitlePages(@RequestParam(defaultValue = "1") Integer pageNum,
                                            @RequestParam(defaultValue = "10") Integer pageSize
                                            ){
        return Result.success(titleService.findPage(pageNum, pageSize));
    }

    @GetMapping("/relativeTitles")
    public Result<Page<Title>> getTitlesByRelativeName(@RequestParam String nconst,
                                                  @RequestParam(defaultValue = "1") Integer pageNum,
                                                  @RequestParam(defaultValue = "10") Integer pageSize){
        return Result.success(titleService.findByRelativeName(nconst, pageNum, pageSize));
    }

    @GetMapping("/bestTitles")
    public Result<Page<Title>> getBestTitles(@RequestParam String type,
                                                  @RequestParam String order,
                                                  @RequestParam(defaultValue = "1") Integer pageNum,
                                                  @RequestParam(defaultValue = "10") Integer pageSize){
        return Result.success(titleService.findBestTitles(type, order, pageNum, pageSize));
    }

    @GetMapping("/type")
    public Result<Page<Title>> getTitlesByType(@PathVariable String type,
                                               @RequestParam(defaultValue = "1") Integer pageNum,
                                               @RequestParam(defaultValue = "10") Integer pageSize){
        return Result.success(titleService.findByType(type, pageNum, pageSize));
    }


}
