package com.example.service;

import com.example.dao.NameDao;
import com.example.entity.Name;
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
public class NameService {
    @Resource
    private NameDao nameDao;

    public Page<Name> findByNconst(String nconst, Integer pageNum, Integer pageSize){//根据nconst查找相关name
        Pageable pageable = PageRequest.of(pageNum-1, pageSize);
        List<Name> names = new ArrayList<>();
        names.add(nameDao.findById(nconst).orElse(null));
        int start = (int)pageable.getOffset();
        // 当前页最后一条数据在List中的位置
        int end = (start + pageable.getPageSize()) > names.size() ? names.size() : ( start + pageable.getPageSize());
        // 配置分页数据
        Page<Name> pageNames = new PageImpl<Name>(names.subList(start, end), pageable, names.size());
        return pageNames;
    }
    public Page<Name> findPage(Integer pageNum, Integer pageSize){//默认获取所有title
        Pageable pageable = PageRequest.of(pageNum-1, pageSize);
        return nameDao.findAll(pageable);
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
