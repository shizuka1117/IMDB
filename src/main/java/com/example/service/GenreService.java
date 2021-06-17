package com.example.service;

import com.example.dao.GenreDao;
import com.example.dao.NameDao;
import com.example.entity.Genre;
import com.example.entity.Name;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GenreService {
    @Resource
    private GenreDao genreDao;

    public List<Genre> findByRelativeTitle(String tconst, Integer pageNum, Integer pageSize){//通过name获取相关title
        return genreDao.findGenresByTitle(tconst);
    }
}
