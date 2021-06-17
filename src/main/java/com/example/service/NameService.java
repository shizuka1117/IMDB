package com.example.service;

import com.example.dao.NameDao;
import com.example.entity.Name;
import com.example.entity.Title;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class NameService {
    @Resource
    private NameDao nameDao;

    public Name findByNconst(String nconst){//根据nconst查找相关name
        return nameDao.findById(nconst).orElse(null);
    }

    public Page<Name> findByPrimaryName(String primaryName, Integer pageNum, Integer pageSize){//通过originalTitle模糊查询获取相关title
        Pageable pageable = PageRequest.of(pageNum-1, pageSize);
        return nameDao.findNameByPrimaryName(primaryName, pageable);
    }

    public Page<Name> findByRelativeTitle(String tconst, Integer pageNum, Integer pageSize){//通过name获取相关title
        Pageable pageable = PageRequest.of(pageNum-1, pageSize);
        return nameDao.findNameByTitle(tconst, pageable);
    }
}
