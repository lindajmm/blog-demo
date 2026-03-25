package com.example.blog_demo.entity;


import lombok.Data;
import java.time.LocalDateTime;
/**
 * @author: Linda
 * @date: 2026/3/24 17:52
 * @description:
 */
@Data  // Lombok 自动生成 getter/setter/toString 等
public class Article {
    private Long id;
    private String title;
    private String content;
    private String author;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
