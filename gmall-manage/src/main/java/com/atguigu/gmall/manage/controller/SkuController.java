package com.atguigu.gmall.manage.controller;

import com.atguigu.gmall.bean.PmsProductSaleAttr;
import com.atguigu.gmall.bean.PmsSkuInfo;
import com.atguigu.gmall.service.SkuService;
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
@Controller
@RequestMapping("/manage")
public class SkuController {
    @Autowired
    SkuService skuService;

    @RequestMapping("/getSkuInfo")
    @ResponseBody
    public PmsSkuInfo getSkuInfo(@RequestParam("skuId") String skuId) {
        PmsSkuInfo pmsSkuInfo = skuService.getSkuInfoFromDb(skuId);
        String spuId = pmsSkuInfo.getProductId();
        return pmsSkuInfo;
    }
    @RequestMapping("/getSpuSaleAttr")
    @ResponseBody
    public List<PmsProductSaleAttr> getSpuSaleAttr(@RequestParam("spuId") String spuId, @RequestParam("skuId") String skuId) {
        List<PmsProductSaleAttr> pmsProductSaleAttrs = skuService.getSkuSaleInfoBySpu(spuId, skuId);
        return pmsProductSaleAttrs;
    }

    @RequestMapping("/getSkuHash")
    @ResponseBody
    List<PmsSkuInfo> getSkuBySpuId(@RequestParam("spuId") String spuId) {
        List<PmsSkuInfo> pmsSkuInfos = skuService.getSkuInfoByspuId(spuId);
        return pmsSkuInfos;
    }
}
