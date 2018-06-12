package com.blog.responsitory;

import com.blog.domain.Article;
import com.blog.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author: yukong
 * @date: 2018/6/7 10:10
 * @description:
 */
public interface ArticleRepository  extends JpaRepository<Article,Long>,JpaSpecificationExecutor<Article> {


    List<Article> findByCategoryOrderByPublishTime(Category category);

}
