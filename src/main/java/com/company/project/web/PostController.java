package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.web.model.MyRequestBody;
import com.company.project.model.Post;
import com.company.project.web.model.PostResult;
import com.company.project.service.PostService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2018/11/06.
*/
@RestController
@RequestMapping("/post")
public class PostController {
    @Resource
    private PostService postService;

    @PostMapping("/add")
    public Result add(Post post) {
        postService.save(post);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        postService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(Post post) {
        postService.update(post);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        Post post = postService.findById(id);
        return ResultGenerator.genSuccessResult(post);
    }


    @PostMapping("/list")
    public Result list(@org.springframework.web.bind.annotation.RequestBody MyRequestBody myRequestBody) {


        List<PostResult> list =postService.getList(myRequestBody);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
