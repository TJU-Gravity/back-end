package com.company.project.dao;

import com.company.project.core.Mapper;
import com.company.project.model.News;
import com.company.project.model.Usernews;

import java.util.List;

public interface UsernewsMapper extends Mapper<Usernews> {
    public void deleteLike(Usernews usernews);
    public List<News> getFavoritesByUsername(String username);

}