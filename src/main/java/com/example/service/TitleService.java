package com.example.service;

import com.example.dao.NameDao;
import com.example.dao.RatingDao;
import com.example.dao.TitleDao;
import com.example.entity.Rating;
import com.example.entity.Title;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

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

    public Page<Title> findByOriginalTitle(String title, Integer pageNum, Integer pageSize){//通过originalTitle模糊查询获取相关title
        Pageable pageable = PageRequest.of(pageNum-1, pageSize);
        return titleDao.findByOriginalTitle(title, pageable);
    }

    public Page<Title> findByRelativeName(String nconst, Integer pageNum, Integer pageSize){//通过name获取相关title
        Pageable pageable = PageRequest.of(pageNum-1, pageSize);
        return titleDao.findByName(nconst, pageable);
    }

    //获取某一类型的best列表
    public Page<Title> findBestTitle(String type, Integer pageNum, Integer pageSize){
        List<String> bestTconst = ratingDao.findBestRatings();
        List<Title> bestTitle = new ArrayList<>();
        //bestTitle = titleDao.findAllById(bestTconst);

        for(int i = 0; i<bestTconst.size(); i++){
            Title title = titleDao.findById(bestTconst.get(i)).orElse(null);
            if(title!=null&&(type==null||title.getType().equals(type)))
                bestTitle.add(title);
        }

        Pageable pageable = PageRequest.of(pageNum-1, pageSize);
        int fromIndex = pageable.getPageSize()*pageable.getPageNumber();
        int toIndex = pageable.getPageSize()*(pageable.getPageNumber()+1);
        List<Title> subList = bestTitle.subList(fromIndex,toIndex);
        Page<Title> res = new PageImpl<>(subList, pageable, bestTitle.size());
        return res;
    }
}
