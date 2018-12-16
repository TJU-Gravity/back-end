package com.company.project.dao;

import java.math.BigDecimal;
import java.util.List;

import com.company.project.core.Mapper;
import com.company.project.model.Teamuser;

public interface TeamuserMapper extends Mapper<Teamuser> {

	public List<Teamuser> findByUsername(String userName);


	public List<Teamuser> findTeamuser(String userName, BigDecimal teamId);
}