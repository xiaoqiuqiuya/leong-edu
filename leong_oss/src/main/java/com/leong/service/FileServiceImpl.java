package com.leong.service;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ObjectMetadata;
import com.leong.util.ConstantPropertiesUtil;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.UUID;

/**
 * @author Leong
 * @description
 * @createDate 2020/11/2 14:09
 * @updateDate 2020/11/2 14:09
 **/
@Service
public class FileServiceImpl implements FileService {

    public String uploadImage(MultipartFile file) {
        OSS ossClient = null;
        String url = null;
        try {
            // 创建OSSClient实例。
            ossClient = new OSSClient(ConstantPropertiesUtil.END_POINT, ConstantPropertiesUtil.ACCESS_KEY_ID, ConstantPropertiesUtil.ACCESS_KEY_SECRET);
            //获取文件名称
            String filename = file.getOriginalFilename();
            //文件名字： lijin.shuai.jpg
            String ext = filename.substring(filename.lastIndexOf("."));
            String newName = UUID.randomUUID().toString() + ext;
            String datePath = new DateTime().toString("yyyy/MM/dd");
            String urlPath = ConstantPropertiesUtil.FILE_HOST + "/" + datePath + "/" + newName;

            // meta设置请求头
            ObjectMetadata meta = new ObjectMetadata();
            meta.setContentType("image/jpg");

            // 上传文件流。
            InputStream in = file.getInputStream();
            ossClient.putObject(ConstantPropertiesUtil.BUCKET_NAME, urlPath, in,meta);

            //返回的数据
            url = "https://"+ConstantPropertiesUtil.BUCKET_NAME + "." + ConstantPropertiesUtil.END_POINT + "/" + urlPath;

            // 关闭OSSClient。
            ossClient.shutdown();
        } catch (Exception e) {
            // 关闭OSSClient。
            ossClient.shutdown();
        }
        return url;
    }
}
