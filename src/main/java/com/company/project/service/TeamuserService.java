package com.company.project.service;
import com.company.project.model.Team;
import com.company.project.model.Teamuser;

import java.math.BigDecimal;
import java.util.List;

import com.company.project.core.Service;
import com.company.project.model.user;


/**
 * Created by CodeGenerator on 2018/12/10.
 */
public interface TeamuserService extends Service<Teamuser> {

	List<Teamuser> findByUsername(String userName);
	 List<user> findTeamMembers(BigDecimal teamId);
	 void removeTeammate(String username,BigDecimal teamId);
	List<Team> myTeams(String usernmae);
 List<Teamuser> findTeamuser(String userName, BigDecimal bigDecimal);

}
