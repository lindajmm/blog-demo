package com.example.blog_demo.exception;


import lombok.Getter;

/**
 * @author: Linda
 * @date: 2026/3/26 12:12
 * @description:
 */
/**
 * 自定义业务异常
 */
@Getter
public class BusinessException extends RuntimeException {

    /**
     * 错误码
     */
    private final Integer code;

    public BusinessException(String message) {
        super(message);
        this.code = 500;
    }

    public BusinessException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    // 常用静态工厂方法
    public static BusinessException notFound(String entityName) {
        return new BusinessException(404, entityName + "不存在");
    }

    public static BusinessException badRequest(String message) {
        return new BusinessException(400, message);
    }
}
