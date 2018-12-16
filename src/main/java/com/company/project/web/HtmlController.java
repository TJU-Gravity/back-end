package com.company.project.web;

import com.alibaba.fastjson.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller

public class HtmlController {



    @GetMapping("/form")
    public String index() {

        return "/web/contest/WebContent/admin/production/form.html";
    }



}
