package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.user;
import com.company.project.service.userService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/add")
    public Result add(user user) {
        userService.save(user);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        userService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(user user) {
        userService.update(user);
        return ResultGenerator.genSuccessResult();
    }
    @PostMapping("/login")
    public Result login(@RequestBody user u) {
        user user = userService.findByUsername(u.getUsername());
        if (user!=null&&user.getPwd().equals(u.getPwd()))
            return ResultGenerator.genSuccessResult(user);
        else return ResultGenerator.genFailResult("error");
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam String username) {
        user user = userService.findByUsername(username);
        return ResultGenerator.genSuccessResult(user);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<user> list = userService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
