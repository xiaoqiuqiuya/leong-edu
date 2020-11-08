package com.leong.pojo.coursevo;

import com.leong.pojo.EduCourse;
import com.leong.pojo.EduCourseDescription;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Leong
 * @description
 * @createDate 2020/11/4 9:12
 * @updateDate 2020/11/4 9:12
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDesc {

    private EduCourse eduCourse;

    private EduCourseDescription eduCourseDescription;

}
