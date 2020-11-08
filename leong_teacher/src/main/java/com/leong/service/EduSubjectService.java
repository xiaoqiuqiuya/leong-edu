package com.leong.service;

import com.leong.pojo.EduSubject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.leong.pojo.subjectvo.ParentSubject;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author Leong
 * @since 2020-11-03
 */
public interface EduSubjectService extends IService<EduSubject> {

    List<String> importExcel(MultipartFile file);

    List<ParentSubject> getTree();

    boolean saveParent(EduSubject subject);

    boolean saveChildren(EduSubject subject);

    boolean deleteById(String id);
}
