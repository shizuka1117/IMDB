package com.example.service;

import com.example.dao.TitleDao;
import com.example.entity.Title;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TitleService {
    @Resource
    private TitleDao titleDao;

    public void save(Title title){
        titleDao.save(title);
    }

    public void del(String tconst){
        titleDao.deleteById(tconst);
    }

    public Title findByTconst(String tconst){
        return titleDao.findById(tconst).orElse(null);
    }

    public Page<Title> findPage(Integer pageNum, Integer pageSize){
        Pageable pageable = PageRequest.of(pageNum-1, pageSize);
        return titleDao.findAll(pageable);
    }

    public Page<Title> findByTitle(String title, Integer pageNum, Integer pageSize){
        Pageable pageable = PageRequest.of(pageNum-1, pageSize);
        return titleDao.findByName(title, pageable);
    }
}
