package com.company.project.web;
import com.alibaba.fastjson.JSONObject;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.*;
import com.company.project.service.TeamService;
import com.company.project.service.userService;
import com.company.project.service.tagService;
import com.company.project.service.TeamuserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import tk.mybatis.mapper.entity.Condition;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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
    @Resource
    private userService userService;
    @Resource
    private tagService tagService;
    
    //1.
    //请求创建团队
    //参数：团队信息(id设为默认值0)
    @PostMapping("/createTeam")
    public Result createTeam(@RequestBody Team newTeam) {
        //获取当前团队数量
        int teamNum=teamService.selectCount(new Team());
        //团队id
        newTeam.setTeamid(teamNum+1);
        //创建时间
        Date date = new Date();// 获取当前时间 
        newTeam.setCreatedate(date);
        teamService.save(newTeam);
        return ResultGenerator.genSuccessResult();
    }

  
    //2.
    //请求加入团队
    //参数：用户名，团队id
    @PostMapping("/addTeammate")
    public Result addTeammate(@RequestParam String username,@RequestParam int teamId) {
        //根据id查询用户名
        //user teammate=userService.findByUsername(username);
        //String uName=teammate.getUsername();

        //插入TeamUser表
        Teamuser teamuser=new Teamuser();
        teamuser.setTeamid(teamId);
        teamuser.setUsername(username);
        //获取系统当前时间
        //SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间 
        //sdf.applyPattern("yyyy-MM-dd");
        Date date = new Date();// 获取当前时间 
        //sdf.format(date);
        teamuser.setAdddate(date);
        teamUserService.save(teamuser);

        //更新Team表(membernum)
        Team team=teamService.findById(teamId);
        team.setMembernum(team.getMembernum()+1);
        teamService.update(team);

        return ResultGenerator.genSuccessResult();
    }

    /*
    //3.
    //请求查询团队列表
    //参数：团队类型
    //返回：团队列表
    @PostMapping("/teamList")
    public Result teamList(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size,
    @RequestBody String param) {
        PageHelper.startPage(page, size);
        
        //根据标签查询
        Condition condition=new Condition(Team.class);
        
        condition.createCriteria().andCondition();
        List<Team> list=teamUserService.findByCondition(condition);

        //需要返回什么信息?
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
    */

    //4.
    //请求查询团队信息：基本信息+队员信息
    //参数：团队id
    //返回：团队信息
    @PostMapping("/teamDetail")
    public Result teamDetail(@RequestParam Integer id) {
        Team team = teamService.findById(id);
        JSONObject teamInfo=new JSONObject();
        //队名
        teamInfo.put("teamname",team.getTeamname());
        //队长姓名
        user captain=userService.findById(team.getCaptainid());
        teamInfo.put("captainName",team.getCaptainid());
        //创建时间
        teamInfo.put("createDate",team.getCreatedate());
        //团队头像url
        teamInfo.put("headshot",team.getHeadshot());
        //成员数量
        int membernum=team.getMembernum();
        teamInfo.put("membernum",membernum);
        //团队简介
        teamInfo.put("introduction",team.getIntroduction());

        //查询TeamUser中的队员信息
        Condition condition=new Condition(Teamuser.class);
        String teamIdStr=String.valueOf(team.getTeamid());
        //查询条件
        condition.createCriteria().andCondition("teamid="+teamIdStr);
        //获取成员列表
        List<Teamuser> list=teamUserService.findByCondition(condition);
        String[] userlist=new String[membernum];
        int index=0;
        for(Teamuser x:list)
        {
            userlist[index]=x.getUsername();
            index=index+1;
        }
        teamInfo.put("userlist",userlist);

        return ResultGenerator.genSuccessResult(teamInfo);
    }


    //5.
    //修改团队信息
    //参数：团队信息
    @PostMapping("/updateTeam")
    public Result updateTeam(Team team){
        teamService.update(team);
        return ResultGenerator.genSuccessResult();
    }

    //6.
    //请求解散团队
    //参数：团队id
    @PostMapping("/deleteTeam")
    public Result deleteTeam(@RequestParam Integer id) {
        //更新Team表
        teamService.deleteById(id);
        //更新TeamUser表
        Condition condition=new Condition(Teamuser.class);
        String teamIdStr=id.toString();
        condition.createCriteria().andCondition("teamid="+teamIdStr);
        List<Teamuser> list=teamUserService.findByCondition(condition);
        List<String> userlist;
        for(Teamuser x:list)
        {
        teamUserService.delete(x);
        }

        return ResultGenerator.genSuccessResult();
    }

    //7.
    //请求移除队员
    //参数：队员名字,团队id
    @PostMapping("/deleteTeammate")
    public Result deleteTeammate(@RequestParam String userName,@RequestParam int teamId) {
        //postService.deleteById(id);
         
        //user teammate=userService.findById(userId);
        //String uName=teammate.getUsername();

        //删除TeamUser表
        Teamuser teamuser=new Teamuser();
        Condition condition=new Condition(Teamuser.class);
        condition.createCriteria().andCondition("username="+userName+"and teamId="+String.valueOf(teamId));
        List<Teamuser> deleteList=teamUserService.findByCondition(condition);
        for(Teamuser d:deleteList)
        {
        	teamUserService.delete(d);
        }
        //更新Team表(membernum)
        Team team=teamService.findById(teamId);
        team.setMembernum(team.getMembernum()-1);
        teamService.update(team);

        return ResultGenerator.genSuccessResult();
    } 
    
    //8.
    //请求查询某个用户的团队列表
    //参数：用户名
    //返回：团队列表
    @PostMapping("/myTeamList")
    public Result myTeamList(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size,
    @RequestBody String userName) {
        PageHelper.startPage(page, size);
        
        //根据用户名查询
        Condition condition=new Condition(Teamuser.class);
        
        condition.createCriteria().andCondition("username="+userName);
        List<Teamuser> teamUserList=teamUserService.findByCondition(condition);
        List<Team> teamList=new ArrayList();
        //根据teamId查询team信息
        for(Teamuser x:teamUserList)
        {
            teamList.add(teamService.findById(x.getTeamid()));
        }
        PageInfo pageInfo = new PageInfo(teamList);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

}
