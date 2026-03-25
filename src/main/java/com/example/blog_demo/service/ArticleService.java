package com.example.blog_demo.service;

import com.example.blog_demo.entity.Article;
import com.example.blog_demo.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/**
 * @author: Linda
 * @date: 2026/3/24 17:54
 * @description:
 */
@Service  // 标识为业务层组件
public class ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    // 新增文章
    @Transactional  // 事务管理
    public Article create(Article article) {
        articleMapper.insert(article);
        return article;  // 插入后 article 对象会有 id 值
    }

    // 删除文章
    @Transactional
    public boolean delete(Long id) {
        return articleMapper.deleteById(id) > 0;
    }

    // 更新文章
    @Transactional
    public boolean update(Article article) {
        return articleMapper.update(article) > 0;
    }

    // 查询所有文章
    public List<Article> listAll() {
        return articleMapper.findAll();
    }

    // 查询单篇文章
    public Article getById(Long id) {
        return articleMapper.findById(id);
    }
}
