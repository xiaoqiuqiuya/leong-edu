package com.leong.pojo.subjectvo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Leong
 * @description
 * @createDate 2020/11/3 14:13
 * @updateDate 2020/11/3 14:13
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParentSubject {

    private String id;

    private String title;

    private List<ChildSubject> children = new ArrayList<ChildSubject>();

}
