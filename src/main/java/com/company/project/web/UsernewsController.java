package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.web.model.MyRequestBody;
import com.company.project.model.News;
import com.company.project.model.Usernews;
import com.company.project.service.UsernewsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
* Created by CodeGenerator on 2018/12/10.
*/
@RestController
@RequestMapping("/usernews")
public class UsernewsController {
    @Resource
    private UsernewsService usernewsService;

    public static class Follow
    {
        String username="";
        Integer newsid=0;
    }
    @PostMapping("/add")
    public Result add(@RequestBody Follow follow) {
        Usernews userNews=new Usernews();
        userNews.setAddtime(new Date());
        userNews.setNewsid(BigDecimal.valueOf(follow.newsid));
        userNews.setUsername(follow.username);
        usernewsService.save(userNews);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(Follow follow) {
        usernewsService.deleteLike(follow.username,BigDecimal.valueOf(follow.newsid));
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(Usernews usernews) {
        usernewsService.update(usernews);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        Usernews usernews = usernewsService.findById(id);
        return ResultGenerator.genSuccessResult(usernews);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Usernews> list = usernewsService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    //未通过测试
    @PostMapping("/favorites")
    public Result favorites(@RequestBody MyRequestBody myRequestBody) {
        if(myRequestBody.username.equals(""))
        {
            return ResultGenerator.genFailResult("need non null username");
        }
        else
        {
            PageHelper.startPage(myRequestBody.page, myRequestBody.size);
            List<News> list = usernewsService.getFavorites(myRequestBody.username);
            PageInfo pageInfo = new PageInfo(list);
            return ResultGenerator.genSuccessResult(pageInfo);

        }

    }
}
