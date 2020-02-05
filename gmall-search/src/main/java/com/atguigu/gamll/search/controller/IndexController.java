package com.atguigu.gamll.search.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zy
 * @creat 2020-02-{DAY}-{TIME}
 */
@Controller
public class IndexController {
    @RequestMapping("index")
    public String index() {
        return "index";
    }
}
