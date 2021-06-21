package com.example.service;

import com.example.dao.RatingDao;
import com.example.dao.TitleDao;
import com.example.entity.Title;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class TitleService {
    @Resource
    private TitleDao titleDao;
    @Resource
    private RatingDao ratingDao;

    public void save(Title title){
        titleDao.save(title);
    }

    public void del(String tconst){
        titleDao.deleteById(tconst);
    }

    public Title findByTconst(String tconst){//根据tconst查找相关title
        return titleDao.findById(tconst).orElse(null);
    }

    public Page<Title> findPage(Integer pageNum, Integer pageSize){//默认获取所有title
        Pageable pageable = PageRequest.of(pageNum-1, pageSize);
        return titleDao.findAll(pageable);
    }

    public Page<Title> findByOriginalTitle(String title, String type, Integer pageNum, Integer pageSize){//通过originalTitle模糊查询获取相关title
        Pageable pageable = PageRequest.of(pageNum-1, pageSize);
        if(type!=null)
            return titleDao.findByOriginalTitle(title, type, pageable);
        return titleDao.findByOriginalTitle(title, pageable);
    }

    public Page<Title> findByRelativeName(String nconst, Integer pageNum, Integer pageSize){//通过name获取相关title
        Pageable pageable = PageRequest.of(pageNum-1, pageSize);
        return titleDao.findByName(nconst, pageable);
    }

    //获取某一类型的best列表
    public Page<Title> findBestTitles(String type, Integer pageNum, Integer pageSize){
        Pageable pageable = PageRequest.of(pageNum-1, pageSize);
        if(type.equals("all")){
            return titleDao.findBestTitles(pageable);
        }
        else{
            return titleDao.findBestTitlesWithType(type, pageable);
        }
    }
}
