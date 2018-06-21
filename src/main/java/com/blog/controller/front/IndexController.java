package com.blog.controller.front;

import com.blog.condition.ArticleCondition;
import com.blog.condition.CategoryCondition;
import com.blog.domain.Article;
import com.blog.domain.Notice;
import com.blog.domain.Result;
import com.blog.domain.Tag;
import com.blog.dto.ArchiveDTO;
import com.blog.dto.CategoryDTO;
import com.blog.dto.TagDTO;
import com.blog.enums.ArticleStatusEnum;
import com.blog.service.ArticleService;
import com.blog.service.CategoryService;
import com.blog.service.NoticeService;
import com.blog.service.TagService;
import com.blog.util.ResultUtil;
import com.blog.vo.ArticleAndTagVO;
import com.blog.vo.ArticleVO;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    @Autowired
    private NoticeService noticeService;

    @GetMapping("/archive/category")
        Result<List<CategoryDTO>> findAllCategory(){
        return ResultUtil.success(categoryService.findAll());
    }

    @GetMapping("/archive/category/{name}")
    Result<List<CategoryDTO>> findAllCategoryByName(@PathVariable String name){
        CategoryCondition categoryCondition = new CategoryCondition();
        categoryCondition.setCategoryName(name);
       List<CategoryDTO> list =categoryService.findByCondition(categoryCondition);
        return ResultUtil.success(list);
    }


    @GetMapping(value = "/article/page")
    private Page<Article> page(@ModelAttribute ArticleCondition articleCondition){
        articleCondition.setArticleStatus(ArticleStatusEnum.PUBLISH.getCode());
        return articleService.listByCondition(articleCondition);
    }

    @GetMapping("/article/id/{id}")
    private Result<ArticleAndTagVO> getById(@PathVariable Long id){
        return ResultUtil.success(articleService.getVoById(id));
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
    @JsonView(Article.SimpleArticleView.class)
    private Result<LinkedHashMap<Integer,List<Article>>> findAllGroupByYear() throws JsonProcessingException {
        return ResultUtil.success(articleService.findAllGroupByYear());
    }


    @GetMapping("/archive/{year}/{month}")
    @JsonView(Article.SimpleArticleView.class)
    private  Result<LinkedHashMap<Integer,List<Article>>> findByYearAndMonth(@PathVariable("year") Integer year,@PathVariable("month") Integer month) {
        return ResultUtil.success(articleService.findByYearAndMonth(year, month));
    }

    @GetMapping("/notice")
    private Result<Notice> findNotice() {
        return ResultUtil.success(noticeService.getLatest());
    }

    @GetMapping("/article/category")
    @JsonView(Article.SimpleArticleView.class)
    private Result<Map<Integer,List<Article>>> findArticleGroupByCategory(){
        return ResultUtil.success(articleService.findArticleGroupByCategory());
    }

    @GetMapping("/article/category/{name}")
    @JsonView(Article.SimpleArticleView.class)
    private Result<Map<Integer,List<Article>>> findArticleGroupByCategoryName(@PathVariable String name){
        return ResultUtil.success(articleService.findArticleGroupByCategory(name));
    }

    @GetMapping("/article/tag")
    @JsonView(Article.SimpleArticleView.class)
    private Result<Map<String,List<Article>>> findArticleGroupByTag(){
        return ResultUtil.success(articleService.findArticleGroupByTag());
    }

    @GetMapping("/article/tag/{name}")
    @JsonView(Article.SimpleArticleView.class)
    private Result<Map<String,List<Article>>> findArticleGroupByTag(@PathVariable String name){
        return ResultUtil.success(articleService.findArticleGroupByTag(name));
    }

}
