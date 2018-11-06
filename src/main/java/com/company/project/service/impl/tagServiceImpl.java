package com.company.project.service.impl;

import com.company.project.dao.tagMapper;
import com.company.project.model.tag;
import com.company.project.service.tagService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/11/06.
 */
@Service
@Transactional
public class tagServiceImpl extends AbstractService<tag> implements tagService {
    @Resource
    private tagMapper gtagMapper;

}
