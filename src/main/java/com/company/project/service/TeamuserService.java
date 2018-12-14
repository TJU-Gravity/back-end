package com.company.project.service;
import com.company.project.model.Teamuser;

import java.math.BigDecimal;
import java.util.List;

import com.company.project.core.Service;


/**
 * Created by CodeGenerator on 2018/12/10.
 */
public interface TeamuserService extends Service<Teamuser> {

	public List<Teamuser> findByUsername(String userName);

	public List<Teamuser> findTeamuser(String userName, BigDecimal bigDecimal);

}
