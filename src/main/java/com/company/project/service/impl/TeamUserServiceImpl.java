package com.company.project.service.impl;

import com.company.project.dao.TeamUserMapper;
import com.company.project.model.TeamUser;
import com.company.project.service.TeamUserService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/11/06.
 */
@Service
@Transactional
public class TeamUserServiceImpl extends AbstractService<TeamUser> implements TeamUserService {
    @Resource
    private TeamUserMapper teamUserMapper;

}
