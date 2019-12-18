package com.atguigu.gmall.service;

import com.atguigu.gmall.bean.*;

import java.util.List;

/**
 * @author zy
 * @creat 2019-12-{DAY}-{TIME}
 */
public interface SpuService {
    List<PmsProductInfo> getSpuInfo(String catalog3Id);

    List<PmsBaseSaleAttr> getBaseSaleAttrList();

    void saveSpuInfo(PmsProductInfo pmsProductInfo);

    List<PmsProductSaleAttr> getSpuSaleAttrList(String spuId);

    List<PmsProductImage> getSpuImageList(String spuId);

    void saveSkuInfo(PmsSkuInfo pmsSkuInfo);
}
