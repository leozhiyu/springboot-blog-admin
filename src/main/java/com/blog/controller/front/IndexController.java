package com.blog.controller.front;

import com.blog.condition.ArticleCondition;
import com.blog.condition.CategoryCondition;
import com.blog.domain.Article;
import com.blog.domain.Category;
import com.blog.domain.Result;
import com.blog.domain.Tag;
import com.blog.dto.ArchiveDTO;
import com.blog.dto.CategoryDTO;
import com.blog.dto.TagDTO;
import com.blog.service.ArticleService;
import com.blog.service.CategoryService;
import com.blog.service.TagService;
import com.blog.util.ResultUtil;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
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

    @GetMapping("/archive/category")
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

    @GetMapping("/archive/month")
    private Result<List<ArchiveDTO>> monthArchive(){
        return ResultUtil.success(articleService.archive());
    }

    @GetMapping("/archive/tag")
    private Result<List<TagDTO>> findAllAndCount(){
        return ResultUtil.success(tagService.findAllAndCount());
    }

    @GetMapping("/article/year")
    @JsonView(Article.ArticleYearView.class)
    private Result<LinkedHashMap<Integer,List<Article>>> findAllGroupByYear() throws JsonProcessingException {
        return ResultUtil.success(articleService.findAllGroupByYear());
    }

    @GetMapping("/archive/{year}/{month}")
    @JsonView(Article.ArticleYearView.class)
    private  Result<LinkedHashMap<Integer,List<Article>>> findByYearAndMonth(@PathVariable("year") Integer year,@PathVariable("month") Integer month){
        return ResultUtil.success(articleService.findByYearAndMonth(year,month));
    }

}
