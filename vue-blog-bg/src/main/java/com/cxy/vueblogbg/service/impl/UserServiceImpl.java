package com.cxy.vueblogbg.service.impl;

import com.cxy.vueblogbg.entity.User;
import com.cxy.vueblogbg.mapper.UserMapper;
import com.cxy.vueblogbg.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author xing-yu-chen
 * @since 2021-07-05
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
