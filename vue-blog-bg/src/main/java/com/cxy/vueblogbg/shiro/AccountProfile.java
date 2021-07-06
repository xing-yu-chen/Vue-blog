package com.cxy.vueblogbg.shiro;

import lombok.Data;

import java.io.Serializable;

//非私密信息封装用于给Shiro公开
@Data
public class AccountProfile implements Serializable {
    private Long id;
    private String username;
    private String avatar;
    private String email;
}