package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.Team;
import com.company.project.service.TeamService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2018/11/06.
*/
@RestController
@RequestMapping("/team")

public class TeamInfo{

    String teamname;
    String captainname;
    Short membernum;
    Date createdate;
    ArrayList<String> member;
    String headshort;
    String  introduction;
    //tags...

    public void setTeamname(String teamname)
    {this.teamname=teamname;}
     public void setCaptainname(String captainName)
    {this.captainname=captainname;}
     public void setMembernum(Short membernum)
    {this.membernum=membernum;}
     public void setCreatedate(Date createdate)
    {this.createdate=createdate;}
     public void setMember(List<String> member)
    {this.member=member;}
     public void setHeadshot(String headshort)
    {this.headshort=headshort;}

     String void getTeamname()
    {return teamname;}
     public String getCaptainname()
    {return captainname;}
     public Short getMembernum()
    {return membernum}
     public Date getCreatedate()
    {return createdate;}
     public List<String> getMember()
    {return member;}
     public Strirng getHeadshot()
    {return headshort;}

}

public class TeamController {
    @Resource
    private TeamService teamService;
    @Resource
    private TeamUserService teamUserService;
    @Resource
    private UserService userService;
    @Resource
    private TagService tagService;
    
    //1.
    //请求创建团队
    //参数：团队信息(id设为默认值0)
    @PostMapping("/createTeam")
    public Result createTeam(@RequestBody Team newTeam) {
        //获取当前团队数量
        BigDecimal teamNum=teamService.selectCount(new Team());
        //团队id
        newTeam.setTeamid(teamNum+1);
        teamService.save(newTeam);
        return ResultGenerator.genSuccessResult();
    }

  
    //2.
    //请求加入团队
    //参数：用户id，团队id
    @PostMapping("/addTeammate")
    public Result addTeammate(@RequestParam BigDecimal userId,@RequestParam BigDecimal teamId) {
        //根据id查询用户名
        User teammate=userService.findById(userId);
        String uName=teammate.getName();

        //插入TeamUser表
        TeamUser teamuser=new TeamUser();
        teamuser.setTeamid(teamId);
        teamuser.setUsername(uName);
        //获取系统当前时间
        //SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间 
        //sdf.applyPattern("yyyy-MM-dd");
        Date date = new Date();// 获取当前时间 
        //sdf.format(date);
        teamuser.setAdddate=date;
        teamUserService.save(teamuser);

        //更新Team表(membernum)
        Team team=teamService.findById(teamId);
        team.setMembernum(team.membernum+1);
        teamService.update(team);

        return ResultGenerator.genSuccessResult();
    }

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

    //4.
    //请求查询团队信息：基本信息+队员信息
    //参数：团队id
    //返回：团队信息
    @PostMapping("/teamDetail")
    public Result teamDetail(@RequestParam Integer id) {
        Team team = teamService.findById(id);
        TeamInfo teamInfo=new TeamInfo();
        teamInfo.
        teamInfo.setTeamname(team.teamname);
        //队长姓名
        teamInfo.setCaptainname(userService.findById(team.captainId).name);

        teamInfo.setMembernum(team.membernum);
        teamInfo.setCreatedate(team.createdate);
        teamInfo.setHeadshort(team.headshort);
        teamInfo.setIntroduction(team.introduction);

        //查询TeamUser中的队员信息
        Condition condition=new Condition(TeamUser.class);
        String teamIdStr=membernum.toString();
        condition.createCriteria().andCondition("teamid="+teamIdStr);
        List<TeamUser> list=teamUserService.findByCondition(condition);
        List<String> userlist;
        for(TeamUser x:list)
        {
            userlist.add(x.username);
        }
        teamInfo.setMember(userlist);

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
        Condition condition=new Condition(TeamUser.class);
        String teamIdStr=membernum.toString();
        condition.createCriteria().andCondition("teamid="+teamIdStr);
        List<TeamUser> list=teamUserService.findByCondition(condition);
        List<String> userlist;
        for(TeamUser x:list)
        {
        teamUserService.delete(x);
        }

        return ResultGenerator.genSuccessResult();
    }

    //7.
    //请求移除队员
    //参数：队员id,团队id
    @PostMapping("/deleteTeammate")
    public Result deleteTeammate(@RequestParam BigDecimal userId,@RequestParam BigDecimal teamId) {
        //postService.deleteById(id);
         //根据id查询用户名
        User teammate=userService.findById(userId);
        String uName=teammate.getName();

        //删除TeamUser表
        TeamUser teamuser=new TeamUser();
        //...
        //更新Team表(membernum)
        Team team=teamService.findById(teamId);
        team.setMembernum(team.membernum-1);
        teamService.update(team);

        return ResultGenerator.genSuccessResult();
    } 

}
