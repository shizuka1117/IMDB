package com.example.controller;

import com.example.common.Result;
import com.example.entity.Name;
import com.example.entity.Title;
import com.example.service.NameService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/name")
public class NameController {
    @Resource
    private NameService nameService;

    @GetMapping("/primaryName/{primaryName}")
    public Result<Page<Name>> getNamesByPrimaryName(@PathVariable String primaryName,
                                        @RequestParam(defaultValue = "1") Integer pageNum,
                                       @RequestParam(defaultValue = "10") Integer pageSize){
        return Result.success(nameService.findByPrimaryName(primaryName, pageNum, pageSize));
    }

    @GetMapping("/page")
    public Result<Page<Name>> getNamePages(@RequestParam(defaultValue = "1") Integer pageNum,
                                             @RequestParam(defaultValue = "10") Integer pageSize){
        return Result.success(nameService.findPage(pageNum, pageSize));
    }

    @GetMapping("/nconst/{nconst}")
    public Result<Page<Name>> getNamesByNconst(@PathVariable String nconst,
                                               @RequestParam(defaultValue = "1") Integer pageNum,
                                               @RequestParam(defaultValue = "10") Integer pageSize
    ){
        return Result.success(nameService.findByNconst(nconst, pageNum, pageSize));
    }

    @GetMapping("/relativeNames/{tconst}")
    public Result<Page<Name>> getNamesByRelativeTitle(@PathVariable String tconst,
                                            @RequestParam(defaultValue = "1") Integer pageNum,
                                            @RequestParam(defaultValue = "10") Integer pageSize){
        return Result.success(nameService.findByRelativeTitle(tconst, pageNum, pageSize));
    }
}
