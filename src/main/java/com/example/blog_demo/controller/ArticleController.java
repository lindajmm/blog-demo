package com.example.blog_demo.controller;


import com.example.blog_demo.entity.Article;
import com.example.blog_demo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

        import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @author: Linda
 * @date: 2026/3/24 17:55
 * @description:
 */
@RestController  // 返回 JSON 数据
@RequestMapping("/api/articles")  // 统一路径前缀
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    // 1. 新增文章
    @PostMapping
    public Map<String, Object> create(@RequestBody Article article) {
        Map<String, Object> result = new HashMap<>();
        try {
            Article saved = articleService.create(article);
            result.put("success", true);
            result.put("data", saved);
        } catch (Exception e) {
            result.put("success", false);
            result.put("message", e.getMessage());
        }
        return result;
    }

    // 2. 删除文章
    @DeleteMapping("/{id}")
    public Map<String, Object> delete(@PathVariable Long id) {
        Map<String, Object> result = new HashMap<>();
        boolean success = articleService.delete(id);
        result.put("success", success);
        if (!success) {
            result.put("message", "文章不存在");
        }
        return result;
    }

    // 3. 更新文章
    @PutMapping("/{id}")
    public Map<String, Object> update(@PathVariable Long id, @RequestBody Article article) {
        Map<String, Object> result = new HashMap<>();
        article.setId(id);  // 设置要更新的ID
        boolean success = articleService.update(article);
        result.put("success", success);
        if (success) {
            result.put("data", articleService.getById(id));
        } else {
            result.put("message", "文章不存在");
        }
        return result;
    }

    // 4. 查询所有文章
    @GetMapping
    public List<Article> list() {
        return articleService.listAll();
    }

    // 5. 查询单篇文章
    @GetMapping("/{id}")
    public Article getById(@PathVariable Long id) {
        return articleService.getById(id);
    }
}
