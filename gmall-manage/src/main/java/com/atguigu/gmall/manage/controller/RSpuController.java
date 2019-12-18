package com.atguigu.gmall.manage.controller;

import com.atguigu.gmall.bean.*;
import com.atguigu.gmall.service.SpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zy
 * @creat 2019-12-{DAY}-{TIME}
 */
@Controller
@RequestMapping("/manage")
public class RSpuController {
    @Autowired
    SpuService spuService;

    @RequestMapping("/getSpuInfo")
    @ResponseBody
    List<PmsProductInfo> getSpuInfo(String catalog3Id) {
        List<PmsProductInfo> productInfos = spuService.getSpuInfo(catalog3Id);
        return productInfos;
    }

    @RequestMapping("/baseSaleAttr")
    @ResponseBody
    List<PmsBaseSaleAttr> getBaseSaleAttrList() {
        List<PmsBaseSaleAttr> saleAttrs = spuService.getBaseSaleAttrList();
        return saleAttrs;
    }

    @ResponseBody
    @RequestMapping("/saveSpuInfo")
    void saveSpuInfo(@RequestBody PmsProductInfo pmsProductInfo) {
        spuService.saveSpuInfo(pmsProductInfo);
    }
    @ResponseBody
    @RequestMapping("/spuSaleAttrList")
    List<PmsProductSaleAttr> getSpuSaleAttrList(@RequestParam("spuId") String spuId) {
        List<PmsProductSaleAttr> saleAttrs = spuService.getSpuSaleAttrList(spuId);
        return saleAttrs;
    }

    @ResponseBody
    @RequestMapping("/spuImageList")
    List<PmsProductImage> getSpuImageList(@RequestParam("spuId") String spuId) {
        List<PmsProductImage> productImages = spuService.getSpuImageList(spuId);
        return productImages;
    }

    @ResponseBody
    @RequestMapping("/saveSkuInfo")
    void saveSkuInfo(@RequestBody PmsSkuInfo pmsSkuInfo) {
        spuService.saveSkuInfo(pmsSkuInfo);
    }
}
