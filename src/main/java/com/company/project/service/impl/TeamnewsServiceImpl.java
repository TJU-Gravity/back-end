package com.company.project.service.impl;

import com.company.project.dao.TeamnewsMapper;
import com.company.project.model.Teamnews;
import com.company.project.service.TeamnewsService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/12/10.
 */
@Service
@Transactional
public class TeamnewsServiceImpl extends AbstractService<Teamnews> implements TeamnewsService {
    @Resource
    private TeamnewsMapper teamnewsMapper;

}
