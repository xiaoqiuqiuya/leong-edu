package com.leong.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.leong.pojo.EduTeacher;
import com.baomidou.mybatisplus.extension.service.IService;
import com.leong.pojo.query.TeacherQuery;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author Leong
 * @since 2020-10-24
 */
public interface EduTeacherService extends IService<EduTeacher> {

    //  讲师模糊查询
    void pageQuery(Page<EduTeacher> page,TeacherQuery teacherQuery);

}
