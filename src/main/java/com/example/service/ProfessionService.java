package com.example.service;

import com.example.dao.ProfessionDao;
import com.example.dao.RatingDao;
import com.example.entity.Profession;
import com.example.entity.Rating;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProfessionService {
    @Resource
    ProfessionDao professionDao;

    List<Profession> findProfession(String nconst){
        return professionDao.findProfessionByName(nconst);
    }
}
