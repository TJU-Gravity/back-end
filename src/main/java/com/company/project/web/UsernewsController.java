package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.News;
import com.company.project.model.Usernews;
import com.company.project.service.UsernewsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/add")
    public Result add(String username,Integer newsid) {
        Usernews userNews=new Usernews();
        userNews.setAddtime(new Date());
        userNews.setNewsid(BigDecimal.valueOf(newsid));
        userNews.setUsername(username);
        usernewsService.save(userNews);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(String username,Integer newsid) {
        usernewsService.deleteLike(username,BigDecimal.valueOf(newsid));
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
    public Result favorites(@RequestParam(defaultValue = "null") String username,@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        if(username.equals("null"))
        {
            return ResultGenerator.genFailResult("need non null username");
        }
        else
        {
            PageHelper.startPage(page, size);
            List<News> list = usernewsService.getFavorites(username);
            PageInfo pageInfo = new PageInfo(list);
            return ResultGenerator.genSuccessResult(pageInfo);

        }

    }
}
