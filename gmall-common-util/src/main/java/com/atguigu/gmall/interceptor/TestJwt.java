package com.atguigu.gmall.interceptor;

import com.atguigu.gmall.util.JwtUtil;

import java.util.HashMap;
import java.util.HashMap;
import java.util.Map;

public class TestJwt {

    public static void main(String[] args) {
        // 浏览器ip
        String ip = "127.0.0.1";
        String browserName = "firefox";
        String salt = ip + browserName;
        // 用户信息
        String userId = "1";
        Map<String,String> map = new HashMap<>();
        map.put("userId",userId);
        // 服务器密钥
        String atguiguKey = "atguigugmall0722";

        Map userMap = JwtUtil.decode(atguiguKey, "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOiIxIn0.1KYFrf80FU3knFNjTmcoywcaJNvSvL7wrKInSI2WeR0", salt);

        System.out.println(userMap);
    }
}
