package com.cxy.vueblogbg.controller;


import com.cxy.vueblogbg.common.lang.Result;
import com.cxy.vueblogbg.entity.User;
import com.cxy.vueblogbg.service.UserService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author xing-yu-chen
 * @since 2021-07-05
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequiresAuthentication
    @GetMapping("/id")
    public Result getUserId(){
        User byId = userService.getById(1L);
        return Result.succ(byId);
    }
    @PostMapping("/save")
    public Result save(@Validated @RequestBody User user){
        return Result.succ(user);
    }
}
