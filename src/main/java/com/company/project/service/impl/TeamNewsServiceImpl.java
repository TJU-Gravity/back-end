package com.company.project.service.impl;

import com.company.project.dao.TeamNewsMapper;
import com.company.project.model.TeamNews;
import com.company.project.service.TeamNewsService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/11/06.
 */
@Service
@Transactional
public class TeamNewsServiceImpl extends AbstractService<TeamNews> implements TeamNewsService {
    @Resource
    private TeamNewsMapper teamNewsMapper;

}
