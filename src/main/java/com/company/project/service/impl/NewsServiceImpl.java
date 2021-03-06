package com.company.project.service.impl;

import com.company.project.dao.NewsMapper;
import com.company.project.model.News;
import com.company.project.service.NewsService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;


/**
 * Created by CodeGenerator on 2018/11/06.
 */
@Service
@Transactional
public class NewsServiceImpl extends AbstractService<News> implements NewsService {
    @Resource
    private NewsMapper newsMapper;


    @Override
    public News findById(BigDecimal id){
        return newsMapper.findById(id);

    }
    @Override
    public void deleteById(BigDecimal id){
         newsMapper.deleteById(id);

    }
}
