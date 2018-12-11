package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.Team;
import com.company.project.model.Teamuser;
import com.company.project.model.user;
import com.company.project.service.userService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import tk.mybatis.mapper.entity.Condition;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2018/11/06.
*/
@RestController
@RequestMapping("/user")
public class userController {
    @Resource
    private userService userService;
    
    //1.注册
    
    @PostMapping("/signin")
    public Result signin(@RequestBody user newuser) {
        userService.save(newuser);
        return ResultGenerator.genSuccessResult();
    }

    //2.登陆
    @PostMapping("/login")
    public Result login(@RequestParam String userName,@RequestParam String password) {

        Condition condition=new Condition(user.class);
        //查询条件
        condition.createCriteria().andCondition("username="+userName+"and pwd="+password);
        //获取用户列表
        List<user> users=userService.findByCondition(condition);
        if(users.isEmpty())
        	return ResultGenerator.genFailResult(null);
        else
        	return ResultGenerator.genSuccessResult(users.get(0));
    }

    //3.修改用户信息
    @PostMapping("/updateUser")
    public Result updateUser(user user) {
        userService.update(user);
        return ResultGenerator.genSuccessResult();
    }

    //4.获取个人信息
    @PostMapping("/userDetail")
    public Result userDetail(@RequestParam String username) {
        user getuser = userService.findByUsername(username);
        return ResultGenerator.genSuccessResult(getuser);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<user> list = userService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
