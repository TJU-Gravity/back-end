package com.company.project.web;
import com.alibaba.fastjson.JSONObject;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.*;
import com.company.project.service.TeamService;
import com.company.project.service.userService;
import com.company.project.service.tagService;
import com.company.project.service.TeamuserService;
import com.company.project.web.model.TeamDetail;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.company.project.web.model.MyRequestBody;

import tk.mybatis.mapper.entity.Condition;

import org.apache.juli.logging.Log;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2018/11/06.
*/
@RestController
@RequestMapping("/team")

public class TeamController {
	
    @Resource
    private TeamService teamService;
    @Resource
    private TeamuserService teamUserService;

    
    //1.
    //请求创建团队
    //参数：team
    @PostMapping("/createTeam")
    public Result createTeam(@RequestBody Team newTeam) {
        BigDecimal teamId=teamService.newTeam(newTeam);
        teamUserService.save(new Teamuser(teamId,newTeam.getCaptainid()));
        return ResultGenerator.genSuccessResult();
    }

  
    //2.
    //请求加入团队
    //参数：username,ID
    //OK
    @PostMapping("/addTeammate")
    public Result addTeammate(@RequestBody MyRequestBody body) {
        Team t=teamService.findById(BigDecimal.valueOf(body.ID));
        t.setMembernum((short)(t.getMembernum()+1));
        try {
            teamService.update(t);
            Teamuser teamuser = new Teamuser(BigDecimal.valueOf(body.ID), body.username);
            teamUserService.save(teamuser);
        }catch (Exception e)
        {
            return ResultGenerator.genFailResult("添加队员失败");
        }

        return ResultGenerator.genSuccessResult();
    }


    //3.
    //我的团队列表
    //username
    //List<Team>
    //OK
    @PostMapping("/teamList")
    public Result teamList(@RequestBody MyRequestBody param) {
        PageHelper.startPage(param.page, param.size);

        List<Team> list=teamService.findMyTeams(param.username);

        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }


    //4.
    //请求查询团队信息：基本信息+队员信息
    //ID
    //teamDetail
    //OK
    @PostMapping("/teamDetail")
    public Result teamDetail(@RequestBody MyRequestBody param) {
        TeamDetail teamDetail=new TeamDetail();
    	teamDetail.team=teamService.findById(BigDecimal.valueOf(param.ID));
        teamDetail.teamMembers=teamUserService.findTeamMembers(BigDecimal.valueOf(param.ID));

        return ResultGenerator.genSuccessResult(teamDetail);
    }


    //5.
    //修改团队信息
    //team
    @PostMapping("/updateTeam")
    public Result updateTeam(@RequestBody Team team){
        teamService.update(team);
        return ResultGenerator.genSuccessResult();
    }

    //6.
    //请求解散团队
    //ID
    //OK
    @PostMapping("/deleteTeam")
    public Result deleteTeam(@RequestBody MyRequestBody param) {

        teamService.deleteById(new BigDecimal(param.ID));
        return ResultGenerator.genSuccessResult();
    }

    //7.
    //请求移除队员
    //username,ID
    //OK
   @PostMapping("/removeTeammate")
   public Result deleteTeammate(@RequestBody MyRequestBody body) {
        teamUserService.removeTeammate(body.username,BigDecimal.valueOf(body.ID));
        return ResultGenerator.genSuccessResult();
   }
//新建post时获取的列表？
    @PostMapping("/myteams")
    public Result myTeams(@RequestBody MyRequestBody body) {
        List<Team> list =teamUserService.myTeams(body.username);
        return ResultGenerator.genSuccessResult(list);
    }





}
