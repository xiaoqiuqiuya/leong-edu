package com.leong.service;

import com.leong.pojo.EduCourse;
import com.baomidou.mybatisplus.extension.service.IService;
import com.leong.pojo.coursevo.CourseDesc;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author Leong
 * @since 2020-11-04
 */
public interface EduCourseService extends IService<EduCourse> {


    String saveCourseDesc(CourseDesc courseDesc);
}
