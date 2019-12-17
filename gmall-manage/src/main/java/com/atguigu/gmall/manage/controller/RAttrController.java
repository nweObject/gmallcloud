package com.atguigu.gmall.manage.controller;

import com.atguigu.gmall.bean.PmsBaseAttrInfo;
import com.atguigu.gmall.bean.PmsBaseAttrValue;
import com.atguigu.gmall.service.AttrService;
import com.atguigu.gmall.util.MyFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author zy
 * @creat 2019-12-{DAY}-{TIME}
 */
@Controller
@RequestMapping("/manage")
public class RAttrController {
    @Autowired
    AttrService attrService;
    @ResponseBody
    @RequestMapping("/getAttrInfo")
    public List<PmsBaseAttrInfo> getAttrInfo(@RequestParam("catalog3Id")String catalog3Id) {
        List<PmsBaseAttrInfo> infoList = attrService.getAttrInfoList(catalog3Id);
        return infoList;
    }
    @RequestMapping("/saveAttrInfo")
    @ResponseBody
    public void saveAttrInfo(@RequestBody PmsBaseAttrInfo pmsBaseAttrInfo) {
        attrService.saveInfo(pmsBaseAttrInfo);
    }
    @RequestMapping("/getAttrValue")
    @ResponseBody
    List<PmsBaseAttrValue> getAttrValueList(String attrId) {
        List<PmsBaseAttrValue> attrValues = attrService.getAttrValueByAttrId(attrId);
        return attrValues;
    }

}
