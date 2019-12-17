package com.atguigu.gmall.manageui.controller;

import com.atguigu.gmall.bean.PmsBaseSaleAttr;
import com.atguigu.gmall.bean.PmsProductImage;
import com.atguigu.gmall.bean.PmsProductInfo;
import com.atguigu.gmall.bean.PmsProductSaleAttr;
import com.atguigu.gmall.manageui.service.ManageServiceFeign;
import com.atguigu.gmall.util.MyFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author zy
 * @creat 2019-12-{DAY}-{TIME}
 */
@Controller
@CrossOrigin
public class SpuController {
    @Autowired
    ManageServiceFeign manageServiceFeign;
    @ResponseBody
    @RequestMapping("spuList")
    public List<PmsProductInfo> spuList(String catalog3Id) {
        List<PmsProductInfo> productInfos = manageServiceFeign.getSpuInfo(catalog3Id);
        return productInfos;
    }

    @ResponseBody
    @RequestMapping("baseSaleAttrList")
    public List<PmsBaseSaleAttr> baseSaleAttrList() {
        List<PmsBaseSaleAttr> baseSaleAttrs = manageServiceFeign.getBaseSaleAttrList();
        return baseSaleAttrs;
    }

    @RequestMapping("fileUpload")
    @ResponseBody
    public String fileUpload(@RequestParam("file") MultipartFile multipartFile) {
        String imgUrl = "";
        imgUrl = MyFileUpload.uploadImage(multipartFile);
        System.out.println(imgUrl);
        return  imgUrl;

    }

    @ResponseBody
    @RequestMapping("saveSpuInfo")
    public void saveSpuInfo(@RequestBody PmsProductInfo pmsProductInfo) {
        manageServiceFeign.saveSpuInfo(pmsProductInfo);
    }

    @ResponseBody
    @RequestMapping("spuSaleAttrList")
    public List<PmsProductSaleAttr> spuSaleAttrList(String spuId) {
        List<PmsProductSaleAttr> saleAttrs = manageServiceFeign.getSpuSaleAttrList(spuId);
        return saleAttrs;
    }

    @ResponseBody
    @RequestMapping("spuImageList")
    public List<PmsProductImage> spuImageList(String spuId) {
        List<PmsProductImage> productImages = manageServiceFeign.getSpuImageList(spuId);
        return productImages;
    }
}
