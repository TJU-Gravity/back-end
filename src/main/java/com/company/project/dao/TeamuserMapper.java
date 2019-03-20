package com.company.project.dao;

import java.math.BigDecimal;
import java.util.List;

import com.company.project.core.Mapper;
import com.company.project.model.Team;
import com.company.project.model.Teamuser;
import com.company.project.model.user;

public interface TeamuserMapper extends Mapper<Teamuser> {

	List<Teamuser> findByUsername(String userName);
	List<user> findTeamMembers(BigDecimal teamid);
	List<Teamuser> findTeamuser(String userName, BigDecimal teamId);
	void removeMember(Teamuser teamuser);
	List<Team> myTeams(String username);
}