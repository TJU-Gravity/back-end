package com.company.project.dao;

import com.company.project.core.Mapper;
import com.company.project.model.News;

import java.math.BigDecimal;
import java.util.List;

public interface NewsMapper extends Mapper<News> {

    public News findById(BigDecimal id);
    public void deleteById(BigDecimal id);
}