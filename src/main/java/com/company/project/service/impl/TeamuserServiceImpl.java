package com.company.project.service.impl;

import com.company.project.dao.TeamuserMapper;
import com.company.project.model.Teamuser;
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
    
    public List<Teamuser> findByUsername(String userName) {
  		return teamuserMapper.findByUsername(userName);
  	}
    
    public List<Teamuser> findTeamuser(String userName,BigDecimal teamId) {
		return teamuserMapper.findTeamuser(userName,teamId);
	}


}
