package com.example.blog_demo.entity;

import com.example.blog_demo.constant.ResultCode;
import lombok.Data;

/**
 * @author: Linda
 * @date: 2026/3/26 10:32
 * @description:
 */

/**
 * 统一响应结果类
 * @param <T> 数据类型
 */
@Data
public class Result<T> {
    //状态码：200=成功，其他=失败
    private Integer code;
    //提示信息
    private String message;
    //返回的数据
    private T data;
    //时间戳
    private Long timestamp;

    /**
     * 私有构造方法，通过静态方法创建
     */
    private Result() {
        this.timestamp = System.currentTimeMillis();
    }

    /**
     * 成功响应（无数据）
     */
    public static <T> Result<T> success() {
        Result<T> result = new Result<>();
        result.setCode(ResultCode.SUCCESS);
        result.setMessage("success");
        return result;
    }

    /**
     * 成功响应（带数据）
     */
    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setCode(ResultCode.SUCCESS);
        result.setMessage("success");
        result.setData(data);
        return result;
    }

    /**
     * 成功响应（自定义消息）
     */
    public static <T> Result<T> success(String message, T data) {
        Result<T> result = new Result<>();
        result.setCode(ResultCode.SUCCESS);
        result.setMessage(message);
        result.setData(data);
        return result;
    }

    /**
     * 失败响应
     */
    public static <T> Result<T> error(String message) {
        Result<T> result = new Result<>();
        result.setCode(ResultCode.INTERNAL_ERROR);
        result.setMessage(message);
        return result;
    }

    /**
     * 失败响应（自定义状态码）
     */
    public static <T> Result<T> error(Integer code, String message) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    /**
     * 业务异常响应（如参数校验失败）
     */
    public static <T> Result<T> badRequest(String message) {
        Result<T> result = new Result<>();
        result.setCode(ResultCode.BAD_REQUEST);
        result.setMessage(message);
        return result;
    }

    /**
     * 未授权响应
     */
    public static <T> Result<T> unauthorized(String message) {
        Result<T> result = new Result<>();
        result.setCode(ResultCode.UNAUTHORIZED);
        result.setMessage(message);
        return result;
    }

    /**
     * 未找到资源响应
     */
    public static <T> Result<T> notFound(String message) {
        Result<T> result = new Result<>();
        result.setCode(ResultCode.NOT_FOUND);
        result.setMessage(message);
        return result;
    }
}