package com.company.project.service.impl;

import com.company.project.dao.TeamMapper;
import com.company.project.dao.TeamuserMapper;
import com.company.project.model.Team;
import com.company.project.model.Teamuser;
import com.company.project.model.user;
import com.company.project.service.TeamuserService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/12/10.
 */
@Service
@Transactional
public class TeamuserServiceImpl extends AbstractService<Teamuser> implements TeamuserService {
    @Resource
    private TeamuserMapper teamuserMapper;
    @Resource
    private TeamMapper teamMapper;
    
    public List<Teamuser> findByUsername(String userName) {
  		return teamuserMapper.findByUsername(userName);
  	}

    @Override
    public List<user> findTeamMembers(BigDecimal teamId) {
        return teamuserMapper.findTeamMembers(teamId);
    }

    @Override
    public void removeTeammate(String username, BigDecimal teamId) {
        teamuserMapper.removeMember(new Teamuser(teamId,username));
        Team t=teamMapper.selectByPrimaryKey(teamId);
        t.setMembernum((short)(t.getMembernum()-1));
        teamMapper.updateByPrimaryKeySelective(t);
    }

    @Override
    public List<Team> myTeams(String usernmae) {
        return teamuserMapper.myTeams(usernmae);
    }

    public List<Teamuser> findTeamuser(String userName,BigDecimal teamId) {
		return teamuserMapper.findTeamuser(userName,teamId);
	}


}
