package com.company.project.dao;

import com.company.project.core.Mapper;
import com.company.project.dao.model.MyPage;
import com.company.project.model.Post;
import com.company.project.web.model.PostResult;

import java.util.List;

public interface PostMapper extends Mapper<Post> {
    List<PostResult> getList(MyPage myPage);
}