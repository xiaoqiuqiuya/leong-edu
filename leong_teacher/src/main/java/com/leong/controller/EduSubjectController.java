package com.leong.controller;


import com.leong.pojo.EduSubject;
import com.leong.pojo.subjectvo.ParentSubject;
import com.leong.result.Result;
import com.leong.service.EduSubjectService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author Leong
 * @since 2020-11-03
 */
@RestController
@RequestMapping("subject")
@CrossOrigin
public class EduSubjectController {

    @Autowired
    private EduSubjectService subjectService;


    @GetMapping("list")
    public Result getTree(){
       List<ParentSubject> subjects =  subjectService.getTree();
       if(subjects != null){
           return Result.ok().data("subject", subjects);
       }else{
           return Result.error();
       }
    }

    @DeleteMapping("{id}")
    public Result deleteSubject(@PathVariable String id){
        boolean b = subjectService.deleteById(id);
        if(b){
            return Result.ok();
        }else {
            return Result.error();
        }
    }

    @ApiOperation(value = "新增一级分类")
    @PostMapping("saveParent")
    public Result saveParent(
            @ApiParam(name = "subject", value = "课程分类对象", required = true)
            @RequestBody EduSubject subject){

        boolean result = subjectService.saveParent(subject);
        if(result){
            return Result.ok();
        }else{
            return Result.error().message("删除失败");
        }
    }

    @ApiOperation(value = "新增二级分类")
    @PostMapping("saveChildren")
    public Result saveLevelTwo(
            @ApiParam(name = "subject", value = "课程分类对象", required = true)
            @RequestBody EduSubject subject){

        boolean result = subjectService.saveChildren(subject);
        if(result){
            return Result.ok();
        }else{
            return Result.error().message("保存失败");
        }
    }


    @PostMapping("import")
    public Result importExcel(MultipartFile file){
        List<String> errorMsg = subjectService.importExcel(file);

        if(StringUtils.isEmpty(errorMsg)){
            return Result.error().data("errorMsg", errorMsg);
        }
        return Result.ok();

    }

}

