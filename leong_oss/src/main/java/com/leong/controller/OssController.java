package com.leong.controller;

import com.leong.result.Result;
import com.leong.service.FileService;
import com.leong.util.ConstantPropertiesUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Leong
 * @description
 * @createDate 2020/11/1 23:53
 * @updateDate 2020/11/1 23:53
 **/
@Api("阿里云文件管理")
@RestController
@RequestMapping("oss")
@CrossOrigin
public class OssController {

    @Autowired
    private FileService fileService;

    @ApiOperation("文件上传")
    @PostMapping("upload")
    public Result upload(
            @ApiParam(name = "file", value = "文件", required = true)
            @RequestParam("file")MultipartFile file,
            @ApiParam(name = "host", value = "文件上传路径", required = false)
            @RequestParam(value = "host", required = false) String host){

        if(!StringUtils.isEmpty(host)){
            ConstantPropertiesUtil.FILE_HOST = host;
        }
       String url =  fileService.uploadImage(file);
       if(StringUtils.isEmpty(url)){
           return Result.error();
       }
        return Result.ok().data("urlPath", url);
    }

}
