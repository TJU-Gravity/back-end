package com.company.project.dao;

import com.company.project.core.Mapper;
import com.company.project.model.user;

public interface userMapper extends Mapper<user> {
    public user findByUsername(String username);
    public void addUser(user u);
}