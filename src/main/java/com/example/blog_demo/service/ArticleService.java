package com.example.blog_demo.service;

import com.example.blog_demo.entity.Article;
import com.example.blog_demo.exception.BusinessException;
import com.example.blog_demo.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.util.List;
/**
 * @author: Linda
 * @date: 2026/3/24 17:54
 * @description:
 */
@Service  // 标识为业务层组件
public class ArticleService {
    private static final Logger log = LoggerFactory.getLogger(ArticleService.class);

    @Autowired
    private ArticleMapper articleMapper;

    // 新增文章
    @Transactional  // 事务管理
    public Article create(Article article) {
       /* articleMapper.insert(article);
        return article;  // 插入后 article 对象会有 id 值*/

        log.info("创建文章，标题：{}，作者：{}", article.getTitle(), article.getAuthor());

        // 参数校验
        if (article.getTitle() == null || article.getTitle().isEmpty()) {
            throw BusinessException.badRequest("文章标题不能为空");
        }

        articleMapper.insert(article);
        log.info("文章创建成功，ID：{}", article.getId());
        return article;
    }

    // 删除文章
    @Transactional
    public boolean delete(Long id) {

//        return articleMapper.deleteById(id) > 0;

        log.warn("删除文章，ID：{}", id);

        // 检查文章是否存在
        Article article = articleMapper.findById(id);
        if (article == null) {
            throw BusinessException.notFound("文章");
        }

        int result = articleMapper.deleteById(id);
        log.info("文章删除成功，ID：{}", id);
        return result > 0;
    }

    // 更新文章
    @Transactional
    public boolean update(Article article) {
        return articleMapper.update(article) > 0;
    }

    // 查询所有文章
    public List<Article> listAll() {
        log.debug("查询所有文章");
        return articleMapper.findAll();
    }

    // 查询单篇文章
    public Article getById(Long id) {
        log.debug("Look for the detail of one article, ID：{}", id);
        Article article = articleMapper.findById(id);
        if(1==1){
            throw new NullPointerException();
        }

        if (article == null) {
            throw BusinessException.notFound("Article");
        }
        return article;
    }
}
