package com.blog.controller;

import com.blog.condition.ArticleCondition;
import com.blog.condition.TagCondition;
import com.blog.domain.Article;
import com.blog.domain.Result;
import com.blog.domain.Tag;
import com.blog.dto.ArticleDTO;
import com.blog.service.ArticleService;
import com.blog.service.TagService;
import com.blog.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/article")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @GetMapping(value = "/page")
    private Page<Article> page(@ModelAttribute ArticleCondition articleCondition){
        return articleService.listByCondition(articleCondition);
    }

    @PostMapping
    private Result<Article> add(@RequestBody ArticleDTO articleDTO){
        this.articleService.save(articleDTO);
        return ResultUtil.success();
    }

    @GetMapping("/id/{id}")
    private Result<Article> getById(@PathVariable Long id){
        return ResultUtil.success(articleService.getById(id));
    }

    @PutMapping
    private Result<Article> update(@RequestBody ArticleDTO tag) {
        articleService.save(tag);
        return ResultUtil.success(tag);
    }

    @DeleteMapping("/id/{id}")
    private Result<Article> deleteById(@PathVariable Long id){
        articleService.deleteById(id);
        return ResultUtil.success();
    }
}
