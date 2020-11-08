package com.leong.exception;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

/**
 * @author Leong
 * @description
 * @createDate 2020/10/25 14:11
 * @updateDate 2020/10/25 14:11
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "自定义异常")
public class EduException extends RuntimeException{

    @ApiModelProperty(value = "状态码")
    private Integer code;
    @ApiModelProperty(value = "错误提示信息")
    private String msg;

    @Override
    public String toString() {
        return "EduException{" +
                "code=" + code +
                ", msg='" + this.getMsg() + '\'' +
                '}';
    }
}
