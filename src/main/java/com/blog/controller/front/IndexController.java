package com.blog.controller.front;

import com.blog.condition.ArticleCondition;
import com.blog.condition.CategoryCondition;
import com.blog.domain.Article;
import com.blog.domain.Category;
import com.blog.domain.Result;
import com.blog.domain.Tag;
import com.blog.dto.CategoryDTO;
import com.blog.service.ArticleService;
import com.blog.service.CategoryService;
import com.blog.service.TagService;
import com.blog.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author: yukong
 * @date: 2018/6/8 09:45
 * @description:
 */
@RestController
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private TagService tagService;
    @Autowired
    private ArticleService articleService;

    @GetMapping("/category")
        Result<List<CategoryDTO>> findAllCategory(){
        return ResultUtil.success(categoryService.findAll());
    }

    @GetMapping("/tag")
    Result<List<Tag>> findAllTag() {
        return ResultUtil.success(tagService.findAll());
    }


    @GetMapping(value = "/article/page")
    private Page<Article> page(@ModelAttribute ArticleCondition articleCondition){
        return articleService.listByCondition(articleCondition);
    }

    @GetMapping("/article/id/{id}")
    private Result<Article> getById(@PathVariable Long id){
        return ResultUtil.success(articleService.getById(id));
    }

}
