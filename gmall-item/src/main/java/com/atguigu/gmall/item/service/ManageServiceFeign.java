package com.atguigu.gmall.item.service;

import com.atguigu.gmall.bean.PmsProductSaleAttr;
import com.atguigu.gmall.bean.PmsSkuInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author zy
 * @creat 2019-12-{DAY}-{TIME}
 */
@FeignClient("GMALL-MANAGE")
public interface ManageServiceFeign {
    @RequestMapping("/manage/getSkuInfo")
    PmsSkuInfo getSkuFromDb(@RequestParam("skuId") String skuId);
    @RequestMapping("/manage/getSpuSaleAttr")
    List<PmsProductSaleAttr> getSpuSaleAttr(@RequestParam("spuId") String spuId, @RequestParam("skuId") String skuId);
    @RequestMapping("/manage/getSkuHash")
    List<PmsSkuInfo> getSkuBySpuId(@RequestParam("spuId") String spuId);
}
