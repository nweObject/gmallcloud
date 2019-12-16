package com.atguigu.gmall.manage.controller;

import com.atguigu.gmall.bean.PmsBaseCatalog1;
import com.atguigu.gmall.service.CatalogService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author zy
 * @creat 2019-12-{DAY}-{TIME}
 */
@Api(tags = "后台管理模块")
@RequestMapping("/manage")
@Controller
public class CatalogController {
    @Autowired
    CatalogService catalogService;
    @RequestMapping("/catalog1")
    public List<PmsBaseCatalog1> getAllCatalog1() {
        List<PmsBaseCatalog1> allCatalog1 = catalogService.getAllCatalog1();
        return allCatalog1;
    }
}
