package com.cxy.vueblogbg.controller;


import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cxy.vueblogbg.common.lang.Result;
import com.cxy.vueblogbg.entity.Blog;
import com.cxy.vueblogbg.service.BlogService;
import com.cxy.vueblogbg.util.ShiroUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.time.LocalDateTime;

/**
 * <p>
 * 博客信息 前端控制器
 * </p>
 *
 * @author xing-yu-chen
 * @since 2021-07-05
 */
@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/blogs/{id}")
    public Result selectId(@PathVariable(name = "id") Long id){
        Blog byId = blogService.getById(id);
        return Result.succ(byId);
    }

    @GetMapping("blogs")
    //defaultValue默认值
    public Result list(@RequestParam(defaultValue = "1") Integer currentPage){

        Page page=new Page(currentPage,5);
        IPage pageData = blogService.page(page,new QueryWrapper<Blog>().orderByDesc("id"));
        return Result.succ(pageData);
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable(name = "id") Long id){
        Blog blog=blogService.getById(id);
        Assert.notNull(blog,"该博客已被删除");
        return Result.succ(blog);
    }


    @RequiresAuthentication//认证后才能访问
    @PostMapping("/edit")
    public Result edit(@Validated @RequestBody Blog blog){
        Blog temp=null;
        //判断是否有id确认编辑还是添加
        if(blog.getId()!=null){
            temp=blogService.getById(blog.getId());
            int i= temp.getUserId();
            Assert.isTrue(i ==  ShiroUtil.getProfile().getId(),"没有权限编辑");
        }else{
            temp=new Blog();
            temp.setUserId(ShiroUtil.getProfile().getId());
            temp.setCreated(LocalDateTime.now());
            temp.setStatus(0);
        }
        BeanUtil.copyProperties(blog,temp,"id","userId","created","status");
        blogService.saveOrUpdate(temp);
        return Result.succ("success");
    }
}
