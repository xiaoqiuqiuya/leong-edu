package com.leong.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.leong.pojo.EduTeacher;
import com.leong.mapper.EduTeacherMapper;
import com.leong.pojo.query.TeacherQuery;
import com.leong.service.EduTeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author Leong
 * @since 2020-10-24
 */
@Service
public class EduTeacherServiceImpl extends ServiceImpl<EduTeacherMapper, EduTeacher> implements EduTeacherService {

    @Override
    public void pageQuery(Page<EduTeacher> page, TeacherQuery teacherQuery) {
        QueryWrapper<EduTeacher> wrapper = new QueryWrapper<>();
        //让sort按从小到大排列
        wrapper.orderByAsc("sort");

        //如果没有查询条件则进行分页查询
        if (teacherQuery != null) {
            //获取用户输入的查询条件
            String name = teacherQuery.getName();
            Integer level = teacherQuery.getLevel();
            String begin = teacherQuery.getBegin();
            String end = teacherQuery.getEnd();

            //判断查询条件是否为空，不为空则插入
            if (!StringUtils.isEmpty(name)) {
                wrapper.like("name", name);
            }

            if (!StringUtils.isEmpty(level)) {
                wrapper.eq("level", level);
            }

            if (!StringUtils.isEmpty(begin)) {
                wrapper.ge("gmt_create", begin);
            }

            if (!StringUtils.isEmpty(end)) {
                wrapper.le("gmt_create", end);
            }

        }
        baseMapper.selectPage(page, wrapper);


    }
}
