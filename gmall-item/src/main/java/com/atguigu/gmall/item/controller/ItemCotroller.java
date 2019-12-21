package com.atguigu.gmall.item.controller;

import com.alibaba.fastjson.JSON;
import com.atguigu.gmall.bean.PmsProductSaleAttr;
import com.atguigu.gmall.bean.PmsSkuInfo;
import com.atguigu.gmall.bean.PmsSkuSaleAttrValue;
import com.atguigu.gmall.item.service.ManageServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zy
 * @creat 2019-12-{DAY}-{TIME}
 */
@Controller
public class ItemCotroller {
    @Autowired
    ManageServiceFeign manageServiceFeign;
    @RequestMapping("{skuId}.html")
    public String item(@PathVariable String skuId, ModelMap modelMap) {
        PmsSkuInfo pmsSkuInfo = manageServiceFeign.getSkuFromDb(skuId);
        String spuId = pmsSkuInfo.getProductId();
        List<PmsProductSaleAttr> spuSaleAttr = manageServiceFeign.getSpuSaleAttr(spuId, skuId);
        //创建hash匹配表通过销售属性匹配sku
        List<PmsSkuInfo> pmsSkuInfosForHash = manageServiceFeign.getSkuBySpuId(spuId);
        Map<String, String> hashMap = new HashMap<>();
        for (PmsSkuInfo skuInfo : pmsSkuInfosForHash) {
            String key = "";
            String skuValueId = skuInfo.getId();
            List<PmsSkuSaleAttrValue> skuSaleAttrValueList = skuInfo.getSkuSaleAttrValueList();
            for (PmsSkuSaleAttrValue pmsSkuSaleAttrValue : skuSaleAttrValueList) {
                key = key +"|"+ pmsSkuSaleAttrValue.getSaleAttrValueId();
            }
            hashMap.put(key,skuValueId);
        }
        String hashMapStr = JSON.toJSONString(hashMap);
        modelMap.put("skuInfo", pmsSkuInfo);
        modelMap.put("spuSaleAttrListCheckBySku", spuSaleAttr);
        modelMap.put("hashMapStr", hashMapStr);
        return "item";
    }
}
