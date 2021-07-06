package com.cxy.vueblogbg.shiro;

import org.apache.shiro.authc.AuthenticationToken;

public class JwtToken implements AuthenticationToken {

    private String token;

    public JwtToken(String jwt){
        this.token=jwt;
    }

    //获取授权用户信息
    @Override
    public Object getPrincipal() {
        return token;
    }

    //返回密钥信息
    @Override
    public Object getCredentials() {
        return token;
    }
}
