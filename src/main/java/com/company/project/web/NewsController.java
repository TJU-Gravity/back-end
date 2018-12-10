package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.News;
import com.company.project.service.NewsService;
import com.company.project.service.UserNewsService;
import com.company.project.service.impl.UserNewsServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
* Created by CodeGenerator on 2018/11/06.
*/
@RestController
@RequestMapping("/news")
public class NewsController {
    @Resource
    private NewsService newsService;


    @PostMapping("/add")
    public Result add(News news) {
        newsService.save(news);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        newsService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(News news) {
        newsService.update(news);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        News news = newsService.findById(BigDecimal.valueOf(id));
        return ResultGenerator.genSuccessResult(news);
    }
    @PostMapping("/like")
    public Result like(@RequestParam Integer newsid,@RequestParam String username) {
        News news = newsService.findById(BigDecimal.valueOf(newsid));
        return ResultGenerator.genSuccessResult(news);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "default") String sortedBy,@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<News> list;
        if(sortedBy.equals("contestTime"))
        {//未实现
            list = newsService.findAll();

        }
        else if(sortedBy.equals("publishTime"))
        {//未实现
            list = newsService.findAll();

        }else
        {
            list = newsService.findAll();

        }

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
            List<News> list = newsService.getFavorites(username);
            PageInfo pageInfo = new PageInfo(list);
            return ResultGenerator.genSuccessResult(pageInfo);

        }

    }
}
