package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.web.model.MyRequestBody;
import com.company.project.model.News;
import com.company.project.service.NewsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

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
    public Result add(@org.springframework.web.bind.annotation.RequestBody News news) {

        newsService.save(news);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@org.springframework.web.bind.annotation.RequestBody Integer id) {
        newsService.deleteById(BigDecimal.valueOf(id));
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(News news) {
        newsService.update(news);
        return ResultGenerator.genSuccessResult();
    }



    @PostMapping("/detail")
    public Result detail(@org.springframework.web.bind.annotation.RequestBody MyRequestBody body) {
        News news = newsService.findById(BigDecimal.valueOf(body.ID));
        return ResultGenerator.genSuccessResult(news);
    }




    @PostMapping("/list")
    public Result list(@RequestBody MyRequestBody myRequestBody) {
        PageHelper.startPage(myRequestBody.page, myRequestBody.size);
        List<News> list;
        if(myRequestBody.sortedBy.equals("contestTime"))
        {//未实现
            list = newsService.findAll();

        }
        else if(myRequestBody.sortedBy.equals("publishTime"))
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
