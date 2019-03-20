package com.company.project.service.impl;

import com.company.project.dao.TeamMapper;
import com.company.project.dao.TeamuserMapper;
import com.company.project.model.News;
import com.company.project.model.Team;
import com.company.project.model.Teamuser;
import com.company.project.service.TeamService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/11/06.
 */
@Service
@Transactional
public class TeamServiceImpl extends AbstractService<Team> implements TeamService {
    @Resource
    private TeamMapper teamMapper;

    public List<Team> findMyTeams(String username)
    {
        return teamMapper.findMyTeams(username);
    }




    @Override
    public BigDecimal newTeam(Team t) {

        t.setCreatedate(new Date());
        teamMapper.newTeam(t);

        return t.getTeamid();

    }



}
