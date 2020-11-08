package com.leong.service.impl;

import com.leong.exception.EduException;
import com.leong.pojo.EduCourse;
import com.leong.mapper.EduCourseMapper;
import com.leong.pojo.coursevo.CourseDesc;
import com.leong.service.EduCourseDescriptionService;
import com.leong.service.EduCourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author Leong
 * @since 2020-11-04
 */
@Service
public class EduCourseServiceImpl extends ServiceImpl<EduCourseMapper, EduCourse> implements EduCourseService {
    @Autowired
    private EduCourseDescriptionService eduCourseDescriptionService;


    @Override
    public String saveCourseDesc(CourseDesc courseDesc) {

            //1、添加课程基本信息表
            int insert = baseMapper.insert(courseDesc.getEduCourse());
            if(insert <= 0){
                throw new EduException(20001,"添加课程失败");
            }
            //2、获取课程表的Id
            String courseId = courseDesc.getEduCourse().getId();
            //3、添加课程描述表
            courseDesc.getEduCourseDescription().setId(courseId);
            boolean save = eduCourseDescriptionService.save(courseDesc.getEduCourseDescription());
            if(!save){
                throw new EduException(20001,"添加描述失败");
            }
            return courseId;

    }
}
