package com.company.project.service.impl;

import com.company.project.dao.userMapper;
import com.company.project.model.user;
import com.company.project.service.userService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/11/06.
 */
@Service
@Transactional
public class userServiceImpl extends AbstractService<user> implements userService {
    @Resource
    private userMapper guserMapper;
    public user findByUsername(String username)
    {
        return guserMapper.findByUsername(username);
    }

}
