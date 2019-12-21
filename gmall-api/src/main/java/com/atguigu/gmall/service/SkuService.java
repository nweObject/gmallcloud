package com.atguigu.gmall.service;

import com.atguigu.gmall.bean.PmsProductSaleAttr;
import com.atguigu.gmall.bean.PmsSkuInfo;

import java.util.List;

/**
 * @author zy
 * @creat 2019-12-{DAY}-{TIME}
 */
public interface SkuService {
    PmsSkuInfo getSkuInfoFromDb(String skuId);

    List<PmsProductSaleAttr> getSkuSaleInfoBySpu(String spuId, String skuId);

    List<PmsSkuInfo> getSkuInfoByspuId(String spuId);
}
