package com.leong.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.leong.pojo.EduUser;
import com.leong.result.Result;
import com.leong.service.EduUserService;
import com.leong.service.impl.EduUserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Leong
 * @description
 * @createDate 2020/10/28 10:17
 * @updateDate 2020/10/28 10:17
 **/
@RestController
@RequestMapping("user")
@Api(value = "用户管理")
@CrossOrigin
public class UserController {


    @Autowired
    EduUserService eduUserService;

    @ApiOperation(value = "用户登录")
    @PostMapping("login")
    public Result userLogin(@RequestBody EduUser user,HttpServletRequest request) {
        QueryWrapper<EduUser> wrapper = new QueryWrapper<>();
        wrapper.eq("username", user.getUsername())
                .eq("password", user.getPassword())
                .eq("deleted", 0);
        EduUser loginUser = eduUserService.getOne(wrapper);
        if (loginUser != null) {
//            登录成功
            return Result.ok().data("token", loginUser.getId());
        } else {
//            登录失败,返回错误信息
            return Result.loginError();
        }

    }
    //    {"code":20000,"data":{
//    "roles":["admin"],
//    "introduction":"I am a super administrator",
//    "avatar":"https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif",
//    "name":"Super Admin"}}
    @ApiOperation(value = "用户信息返回")
    @GetMapping("info")
    public Result userInfo(HttpServletRequest request) {

        return Result.ok()
                .data("roles", "[\"admin\"]")
                .data("introduction", "I am a super administrator")
                .data("name","Super Admin")
                .data("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
    }
}
