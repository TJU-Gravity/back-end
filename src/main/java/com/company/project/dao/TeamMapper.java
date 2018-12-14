package com.company.project.dao;

import java.math.BigDecimal;

import com.company.project.core.Mapper;
import com.company.project.model.Team;
import java.math.BigDecimal;
import java.util.List;

public interface TeamMapper extends Mapper<Team> {

	public Team findById(BigDecimal id);

	public void deleteById(BigDecimal id);
}