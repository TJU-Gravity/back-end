package com.company.project.service.impl;

import com.company.project.dao.UsernewsMapper;
import com.company.project.model.News;
import com.company.project.model.Usernews;
import com.company.project.service.UsernewsService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;


/**
 * Created by CodeGenerator on 2018/12/10.
 */
@Service
@Transactional
public class UsernewsServiceImpl extends AbstractService<Usernews> implements UsernewsService {
    @Resource
    private UsernewsMapper usernewsMapper;

    @Override
    public void deleteLike(String username, BigDecimal newsid) {
        Usernews usernews=new Usernews();
        usernews.setNewsid(newsid);
        usernews.setUsername(username);
        usernewsMapper.deleteLike(usernews);
    }
    @Override
    public List<News> getFavorites(String username)
    {
        List<News> favorites=usernewsMapper.getFavoritesByUsername(username);
        return favorites;
    }
}
