package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.News;
import com.company.project.service.NewsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.stereotype.Controller;



/**
* Created by CodeGenerator on 2018/11/06.
*/
@RestController
@RequestMapping("/news")
public class NewsController {
    @Resource
    private NewsService newsService;


    @PostMapping("/add")
    public Result add(@RequestBody News news) {

        newsService.save(news);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Integer id) {
        newsService.deleteById(BigDecimal.valueOf(id));
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(News news) {
        newsService.update(news);
        return ResultGenerator.genSuccessResult();
    }

    public static class ID
    {
        Integer id=0;
    }

    @PostMapping("/detail")
    public Result detail(@RequestBody ID id) {
        News news = newsService.findById(BigDecimal.valueOf(id.id));
        return ResultGenerator.genSuccessResult(news);
    }


   public static class ListParam
    {
       String sortedBy="";
       Integer page=0;
       Integer size=0;
    }

    @PostMapping("/list")
    public Result list(ListParam listParam) {
        PageHelper.startPage(listParam.page, listParam.size);
        List<News> list;
        if(listParam.sortedBy.equals("contestTime"))
        {//未实现
            list = newsService.findAll();

        }
        else if(listParam.sortedBy.equals("publishTime"))
        {//未实现
            list = newsService.findAll();

        }else
        {
            list = newsService.findAll();

        }

        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }


}
