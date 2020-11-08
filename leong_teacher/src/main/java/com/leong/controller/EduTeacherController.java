package com.leong.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.leong.pojo.EduTeacher;
import com.leong.pojo.query.TeacherQuery;
import com.leong.result.Result;
import com.leong.service.EduTeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author Leong
 * @since 2020-10-24
 */
@RestController
@RequestMapping("/teacher")
@CrossOrigin
@Api(value = "讲师管理")
public class EduTeacherController {

    @Autowired
    private EduTeacherService teacherService;

    @ApiOperation(value = "新增讲师")
    @PostMapping("/save")
    public Result InsertTeacher(
            @ApiParam(name = "Teacher",value = "讲师信息")
            @RequestBody EduTeacher eduTeacher){
        try {
            teacherService.save(eduTeacher);
            return Result.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error();
        }
    }

    @ApiOperation(value = "根据ID查询讲师")
    @GetMapping("/{id}")
    public Result queryById(
            @ApiParam(name = "id",value = "讲师ID",required = true)
            @PathVariable(value = "id") String id){
        try {
            EduTeacher teacher = teacherService.getById(id);
            return Result.ok().data("teacher", teacher);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error();
        }
    }

    @ApiOperation(value = "修改讲师")
    @PutMapping("/update")
    public Result updateTeacher(
            @ApiParam(name = "EduTeacher",value = "讲师信息")
            @RequestBody EduTeacher eduTeacher){

        try {
            teacherService.updateById(eduTeacher);
            return Result.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error();
        }

    }



    @ApiOperation(value = "删除讲师")
    @DeleteMapping("{id}")
    public Result deleteTeacherById(
            @ApiParam(name = "id",value = "讲师Id",required = true)
            @PathVariable(name = "id") String id){
        try {
            teacherService.removeById(id);
            return Result.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error();
        }
    }

    @ApiOperation(value = "获取所有讲师")
    @GetMapping("getTeacherList")
    public Result getTeachers(){
        List<EduTeacher> list = teacherService.list(null);
        return Result.ok().data("teacherList",list);
    }


    // 【注意】 GetMapping不能与 @RequestBody一起使用
    @ApiOperation(value = "讲师分页查询")
    @PostMapping("/{page}/{limit}")
    public Result getPage(
            @ApiParam(name = "page",value = "当前页码",defaultValue = "1")
            @PathVariable(value = "page") Integer page,
            @ApiParam(name = "limit",value = "每页显示数",defaultValue = "5")
            @PathVariable(value = "limit") Integer limit,
            @ApiParam(name = "teacherQuery", value = "查询对象", required = false)
            //@RequestBody把JSON字符串转化成对象
            @RequestBody TeacherQuery teacherQuery){

        Page<EduTeacher> teacherPage = new Page<>(page, limit);
        teacherService.pageQuery(teacherPage, teacherQuery);
        System.out.println(teacherQuery.toString());
        //获取分页数据
        List<EduTeacher> records = teacherPage.getRecords();
        //获取总条数
        long total = teacherPage.getTotal();
        return Result.ok().data("totalNum", total).data("rows", records);
    }






}

