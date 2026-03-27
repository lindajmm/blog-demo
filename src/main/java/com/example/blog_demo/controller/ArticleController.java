package com.example.blog_demo.controller;


import com.example.blog_demo.entity.Article;
import com.example.blog_demo.entity.Result;
import com.example.blog_demo.exception.BusinessException;
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
    public Result<Article> create(@RequestBody Article article) {
//        Map<String, Object> result = new HashMap<>();
        try {
            Article saved = articleService.create(article);
          /*  result.put("success", true);
            result.put("data", saved);*/
            return Result.success(saved);
        } catch (Exception e) {
            /*result.put("success", false);
            result.put("message", e.getMessage());*/
            return Result.error("failed to create one article");
        }
//        return result;
    }

    // 2. 删除文章
    @DeleteMapping("/{id}")
//    public Map<String, Object> delete(@PathVariable Long id) {
    public Result<Void> delete(@PathVariable Long id) {
//        Map<String, Object> result = new HashMap<>();
        boolean success = articleService.delete(id);
        if(success){
            return Result.success();
        }else {
//            result.put("message", "文章不存在");
            throw new RuntimeException("the article you are trying to delete doesn't exist");
        }
//        return result;
    }

    // 3. 更新文章
    @PutMapping("/{id}")
    public Result<Article> update(@PathVariable Long id, @RequestBody Article article) {
//        Map<String, Object> result = new HashMap<>();
        article.setId(id);  // 设置要更新的ID
        boolean success = articleService.update(article);
//        result.put("success", success);
        if (success) {
//            result.put("data", articleService.getById(id));
            return Result.success(articleService.getById(id));
        } else {
            throw new RuntimeException("the article you are trying to update doesn't exist");
//            return Result.error("the article you are trying to update doesn't exist ");
//            result.put("message", "文章不存在");
        }
//        return result;
    }

    // 4. 查询所有文章
    @GetMapping
    public Result<List<Article>> list() {
        return Result.success(articleService.listAll());
    }

    // 5. 查询单篇文章
    @GetMapping("/{id}")
    public Result<Article> getById(@PathVariable Long id) {
        Article article = articleService.getById(id);
      /*  if(article != null){
            return Result.success(article);
        }else{
//            return Result.notFound("article not found");
            throw new RuntimeException("article not found");
        }*/

        if(article == null){
            throw BusinessException.notFound("Business exception: article not found");
        }
        return Result.success(article);
    }
}
