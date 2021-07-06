package com.cxy.vueblogbg.common.lang;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result implements Serializable {
    //200是正常，非200表示异常
    private int code;
    private String msg;
    private Object data;

    //成功的结果
    public static Result succ(Object data){
        return succ(200,"操作成功",data);
    }

    public static Result succ(int code,String msg,Object data){
        Result result=new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    //异常数据的调用方法
    //数据异常｜密码错误等
    public static Result fail(String msg){
       return fail(400,msg,null);
    }

    //返回错误方法
    public static Result fail(String msg,Object data){
        return fail(400,msg,data);
    }

    public static Result fail(int code,String msg,Object data){
        Result result=new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }
}
