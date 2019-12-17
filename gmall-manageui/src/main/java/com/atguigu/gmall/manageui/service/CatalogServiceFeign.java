package com.atguigu.gmall.manageui.service;

import com.atguigu.gmall.bean.PmsBaseCatalog1;
import com.atguigu.gmall.bean.PmsBaseCatalog2;
import com.atguigu.gmall.bean.PmsBaseCatalog3;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author zy
 * @creat 2019-12-{DAY}-{TIME}
 */
@FeignClient("GMALL-MANAGE")
public interface CatalogServiceFeign {
    @RequestMapping("/manage/catalog1")
    List<PmsBaseCatalog1> getAllCatalog1();
    @RequestMapping("/manage/catalog2")
    List<PmsBaseCatalog2> getCatalog2ById(@RequestParam("catalog1Id") String catalog1Id);
    @RequestMapping("/manage/catalog3")
    List<PmsBaseCatalog3> getCatalog3By2Id(@RequestParam("catalog2Id") String catalog2Id);
}
