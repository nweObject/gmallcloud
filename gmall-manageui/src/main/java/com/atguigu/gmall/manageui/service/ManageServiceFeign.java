package com.atguigu.gmall.manageui.service;

import com.atguigu.gmall.bean.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zy
 * @creat 2019-12-{DAY}-{TIME}
 */
@FeignClient("GMALL-MANAGE")
public interface ManageServiceFeign {
    @RequestMapping("/manage/catalog1")
    List<PmsBaseCatalog1> getAllCatalog1();

    @RequestMapping("/manage/catalog2")
    List<PmsBaseCatalog2> getCatalog2ById(@RequestParam("catalog1Id") String catalog1Id);

    @RequestMapping("/manage/catalog3")
    List<PmsBaseCatalog3> getCatalog3By2Id(@RequestParam("catalog2Id") String catalog2Id);

    @RequestMapping("/manage/getAttrInfo")
    List<PmsBaseAttrInfo> attrInfoList(@RequestParam("catalog3Id") String catalog3Id);

    @RequestMapping("/manage/saveAttrInfo")
    void saveAttrInfo(@RequestBody PmsBaseAttrInfo pmsBaseAttrInfo);

    @RequestMapping("/manage/getAttrValue")
    List<PmsBaseAttrValue> getAttrValueList(String attrId);

    @RequestMapping("/manage/getSpuInfo")
    List<PmsProductInfo> getSpuInfo(@RequestParam("catalog3Id") String catalog3Id);

    @RequestMapping("/manage/baseSaleAttr")
    List<PmsBaseSaleAttr> getBaseSaleAttrList();

    @RequestMapping("/manage/saveSpuInfo")
    void saveSpuInfo(@RequestBody PmsProductInfo pmsProductInfo);

    @RequestMapping("/manage/spuSaleAttrList")
    List<PmsProductSaleAttr> getSpuSaleAttrList(@RequestParam("spuId") String spuId);

    @RequestMapping("/manage/spuImageList")
    List<PmsProductImage> getSpuImageList(@RequestParam("spuId") String spuId);
}
