package com.company.project.service;
import com.company.project.model.News;
import com.company.project.model.Team;

import java.math.BigDecimal;

import com.company.project.core.Service;


/**
 * Created by CodeGenerator on 2018/11/06.
 */
public interface TeamService extends Service<Team> {
		
	    public Team findById(BigDecimal id);
	    public void deleteById(BigDecimal id);
}
