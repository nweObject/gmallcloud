package com.atguigu.gmall.manage.controller;

import com.atguigu.gmall.bean.PmsBaseCatalog1;
import com.atguigu.gmall.bean.PmsBaseCatalog2;
import com.atguigu.gmall.bean.PmsBaseCatalog3;
import com.atguigu.gmall.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author zy
 * @creat 2019-12-{DAY}-{TIME}
 */
@RequestMapping("/manage")
@Controller
@ResponseBody
public class CatalogController {
    @Autowired
    CatalogService catalogService;
    @RequestMapping("/catalog1")
    public List<PmsBaseCatalog1> getAllCatalog1() {
        List<PmsBaseCatalog1> allCatalog1 = catalogService.getAllCatalog1();
        return allCatalog1;
    }
    @RequestMapping("/catalog2")
    public List<PmsBaseCatalog2> getCatalog2ById(@RequestParam("catalog1Id") String catalog1Id) {
        List<PmsBaseCatalog2> catalog2s = catalogService.getCatalog2(catalog1Id);
        return catalog2s;
    }
    @RequestMapping("/catalog3")
    @ResponseBody
    public List<PmsBaseCatalog3> getCatalog3(@RequestParam("catalog2Id") String catalog2Id) {
        List<PmsBaseCatalog3> catalog3s = catalogService.getCatalog3(catalog2Id);
        return catalog3s;
    }
}
