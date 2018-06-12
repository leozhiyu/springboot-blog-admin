package com.blog.responsitory;

import com.blog.domain.Article;
import com.blog.domain.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author: yukong
 * @date: 2018/6/12 14:55
 * @description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleRepositoryTest {

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void findByCategoryOrderByPublishTime() {
        Category category = categoryRepository.findCategoryByCategoryName("算法集合1");
        List<Article> articles = articleRepository.findByCategoryOrderByPublishTime(category);
        System.out.println(articles.size());
    }
}