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

    public void save(Title title){
        titleDao.save(title);
    }

    public void del(String tconst){
        titleDao.deleteById(tconst);
    }

    public Page<Title> findByTconst(String tconst, Integer pageNum, Integer pageSize){//根据tconst查找相关title
        Pageable pageable = PageRequest.of(pageNum-1, pageSize);
        List<Title> titles = new ArrayList<>();
        titles.add(titleDao.findById(tconst).orElse(null));
        int start = (int)pageable.getOffset();
        // 当前页最后一条数据在List中的位置
        int end = (start + pageable.getPageSize()) > titles.size() ? titles.size() : ( start + pageable.getPageSize());
        // 配置分页数据
        Page<Title> pageTitles = new PageImpl<Title>(titles.subList(start, end), pageable, titles.size());
        return pageTitles;
    }

    public Page<Title> findPage(Integer pageNum, Integer pageSize){//默认获取所有title
        Pageable pageable = PageRequest.of(pageNum-1, pageSize);
        return titleDao.findAll(pageable);
    }

    public Page<Title> findByOriginalTitle(String title, Integer pageNum, Integer pageSize){//通过originalTitle模糊查询获取相关title
        Pageable pageable = PageRequest.of(pageNum-1, pageSize);
        return titleDao.findByOriginalTitle(title, pageable);
    }

    public Page<Title> findByRelativeName(String nconst, Integer pageNum, Integer pageSize){//通过name获取相关title
        Pageable pageable = PageRequest.of(pageNum-1, pageSize);
        return titleDao.findByName(nconst, pageable);
    }

    //获取某一类型的best列表
    public Page<Title> findBestTitles(String type, String order, Integer pageNum, Integer pageSize){
        Pageable pageable = PageRequest.of(pageNum-1, pageSize);
        if(type.equals("all")){
            if(order.equals("asc"))
                return titleDao.findBestTitlesAsc(pageable);
            else
                return titleDao.findBestTitlesDesc(pageable);
        }
        else{
            if(order.equals("asc"))
                return titleDao.findBestTitlesWithTypeAsc(type, pageable);
            else
                return titleDao.findBestTitlesWithTypeDesc(type, pageable);
        }
    }

    public Page<Title> findByType(String type, Integer pageNum, Integer pageSize){
        Pageable pageable = PageRequest.of(pageNum-1, pageSize);
        return titleDao.findByType(type, pageable);
    }
}
