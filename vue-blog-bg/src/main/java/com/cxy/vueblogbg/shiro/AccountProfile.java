package com.cxy.vueblogbg.shiro;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

//非私密信息封装用于给Shiro公开
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountProfile implements Serializable {
    private Integer id;
    private String username;
    private String avatar;
    private String email;
}