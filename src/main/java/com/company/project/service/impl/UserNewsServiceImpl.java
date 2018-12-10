package com.company.project.service.impl;

import com.company.project.dao.UserNewsMapper;
import com.company.project.model.News;
import com.company.project.model.UserNews;
import com.company.project.service.UserNewsService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by CodeGenerator on 2018/11/06.
 */
@Service
@Transactional
public class UserNewsServiceImpl extends AbstractService<UserNews> implements UserNewsService {
    @Resource
    private UserNewsMapper userNewsMapper;



}
