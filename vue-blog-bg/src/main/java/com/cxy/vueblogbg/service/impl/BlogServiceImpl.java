package com.cxy.vueblogbg.service.impl;

import com.cxy.vueblogbg.entity.Blog;
import com.cxy.vueblogbg.mapper.BlogMapper;
import com.cxy.vueblogbg.service.BlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 博客信息 服务实现类
 * </p>
 *
 * @author xing-yu-chen
 * @since 2021-07-05
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

}
