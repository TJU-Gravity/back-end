package com.company.project.web.model;

import com.company.project.model.Post;
import com.company.project.model.Team;
import com.company.project.model.user;


import java.util.List;

public class PostDetail {
    public Post post;
    public user user;
    public List<ReplyResult> replies;
    public Team team;
}
