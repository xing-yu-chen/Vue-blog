package com.cxy.vueblogbg.util;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.cxy.vueblogbg.shiro.AccountProfile;
import org.apache.shiro.SecurityUtils;

import javax.sound.midi.Soundbank;

public class ShiroUtil {

    public static AccountProfile getProfile(){
        System.out.println(SecurityUtils.getSubject().getPrincipal()+"======1");
        JSONObject json = JSONUtil.parseObj(SecurityUtils.getSubject().getPrincipal());
        System.out.println(json);
        return  JSONUtil.toBean(json,AccountProfile.class);
    }
}
