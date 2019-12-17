package com.atguigu.gmall.util;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.web.multipart.MultipartFile;

public class MyFileUpload {

//    public static void main(String[] args) {
//        String img = "123123123123,1231131231,.123123,123131.sfd.sdfsdfdsfsf3.png";
//        int i = img.lastIndexOf(".");
//        System.out.println(i);
//        String substring = img.substring(i + 1);
//        System.out.println(substring);
//
//    }

    public static String uploadImage(MultipartFile multipartFile) {

        String url = "http://192.168.130.128";
        String trackerPath = MyFileUpload.class.getClassLoader().getResource("tracker.properties").getPath();
        // 全局配置
        try {
            ClientGlobal.init(trackerPath);

            // 获得客户端
            TrackerClient trackerClient = new TrackerClient();

            TrackerServer connection = trackerClient.getConnection();

            StorageClient storageClient = new StorageClient(connection, null);

            // 上传文件
            String originalFilename = multipartFile.getOriginalFilename();
            int i = originalFilename.lastIndexOf(".");
            String substring = originalFilename.substring(i + 1);
            String[] paths = storageClient.upload_file(multipartFile.getBytes(), substring, null);

            for (String path : paths) {
                url =  url + "/" + path;
            }
        } catch (Exception e) {
            // 处理上传异常事件
        } finally {

        }

        return url;
    }
}
