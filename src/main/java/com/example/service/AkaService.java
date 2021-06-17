package com.example.service;

import com.example.dao.AkaDao;
import com.example.entity.Aka;
import com.example.entity.Genre;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AkaService {
    @Resource
    AkaDao akaDao;

    public List<Aka> findByTconst(String tconst, Integer pageNum, Integer pageSize){//通过name获取相关title
        return akaDao.findAkaByTconst(tconst);
    }
}
