package com.example.blog_demo.mapper;






import com.example.blog_demo.entity.Article;
import org.apache.ibatis.annotations.*;

        import java.util.List;
/**
 * @author: Linda
 * @date: 2026/3/24 17:53
 * @description:
 */
@Mapper  // 让 Spring 扫描到这个接口
public interface ArticleMapper {

    // 新增文章
    @Insert("INSERT INTO article(title, content, author) VALUES(#{title}, #{content}, #{author})")
    @Options(useGeneratedKeys = true, keyProperty = "id")  // 返回自增主键
    int insert(Article article);

    // 删除文章
    @Delete("DELETE FROM article WHERE id = #{id}")
    int deleteById(Long id);

    // 更新文章
    @Update("UPDATE article SET title = #{title}, content = #{content}, author = #{author} WHERE id = #{id}")
    int update(Article article);

    // 查询所有文章
    @Select("SELECT * FROM article ORDER BY create_time DESC")
    List<Article> findAll();

    // 根据ID查询文章
    @Select("SELECT * FROM article WHERE id = #{id}")
    Article findById(Long id);
}
