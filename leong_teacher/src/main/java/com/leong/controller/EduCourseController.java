package com.leong.controller;


import com.leong.pojo.coursevo.CourseDesc;
import com.leong.result.Result;
import com.leong.service.EduCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author Leong
 * @since 2020-11-04
 */
@RestController
@RequestMapping("/course")
@CrossOrigin
public class EduCourseController {

    @Autowired
    private EduCourseService eduCourseService;

    @PostMapping("save")
    public Result saveCourse(@RequestBody CourseDesc courseDesc){ //接收课程和描述对象

        try {
            //接收课程和描述对象
            String courseId = eduCourseService.saveCourseDesc(courseDesc);
            return Result.ok().data("courseId",courseId);

        } catch (Exception e) {
            e.printStackTrace();
            return Result.error();
        }
    }

}

