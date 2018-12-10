package com.company.project.service;
import com.company.project.model.News;
import com.company.project.model.Usernews;
import com.company.project.core.Service;

import java.math.BigDecimal;
import java.util.List;


/**
 * Created by CodeGenerator on 2018/12/10.
 */
public interface UsernewsService extends Service<Usernews> {
    public List<News> getFavorites(String username);
    public void deleteLike(String username, BigDecimal newsid);
}
