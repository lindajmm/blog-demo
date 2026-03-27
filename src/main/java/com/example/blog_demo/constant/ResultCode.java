package com.example.blog_demo.constant;

/**
 * @author: Linda
 * @date: 2026/3/26 10:56
 * @description:
 */

/**
 * 响应状态码常量
 */
public class ResultCode {

    public static final Integer SUCCESS = 200;//成功
    public static final Integer BAD_REQUEST = 400;//参数错误
    public static final Integer UNAUTHORIZED = 401;//未授权
    public static final Integer NOT_FOUND = 404;//未找到资源
    public static final Integer INTERNAL_ERROR = 500;//服务器内部错误
    public static final Integer BUSINESS_ERROR = 1000;//业务异常
}