package com.company.project.service;
import com.company.project.model.News;
import com.company.project.model.Team;

import java.math.BigDecimal;
import java.util.List;

import com.company.project.core.Service;


/**
 * Created by CodeGenerator on 2018/11/06.
 */
public interface TeamService extends Service<Team> {
	List<Team> findMyTeams(String username);
	    public Team findById(BigDecimal id);
	    public void deleteById(BigDecimal id);
		public void insertTeam(Team newTeam);
}
