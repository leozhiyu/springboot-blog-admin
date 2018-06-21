package com.blog.service.impl;

import com.blog.domain.Article;
import com.blog.domain.Category;
import com.blog.domain.Tag;
import com.blog.dto.ArticleDTO;
import com.blog.responsitory.ArticleRepository;
import com.blog.service.ArticleService;
import com.blog.service.TagService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashSet;

import static org.junit.Assert.*;

/**
 * @author: yukong
 * @date: 2018/6/21 09:20
 * @description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleServiceImplTest {


    @Autowired
    private CategoryServiceImpl categoryService;

    @Autowired
    private ArticleService articleService;
    @Autowired
    private TagService tagService;
    @Autowired
    private ArticleRepository articleRepository;

    @Test
    public void deleteById() {
        Category category = new Category();
        category.setCategoryName("标签");
        category.setCategoryWeight(1);
        categoryService.save(category);
      /*  Tag tag = new Tag();
        tag.setTagName("标题1");
        tagService.save(tag);*/
        ArticleDTO article = new ArticleDTO();
        article.setArticleTitle("标题");
        article.setArticleContent("内容");
        ArrayList<Long> arrayList =new ArrayList();
        arrayList.add(6L);
        article.setTagIds(arrayList);
        article.setCategoryId(category.getId());
        articleService.save(article);

    }


    @Test
    public void delete(){
       // tagService.deleteById(5L);
        articleService.deleteById(6L);
       // articleRepository.deleteAll();
    }
}