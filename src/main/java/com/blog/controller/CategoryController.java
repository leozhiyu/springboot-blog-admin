package com.blog.controller;

import com.blog.condition.CategoryCondition;
import com.blog.domain.Category;
import com.blog.domain.Result;
import com.blog.service.CategoryService;
import com.blog.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping(value = "/page")
    private Page<Category> page(@ModelAttribute CategoryCondition categoryCondition){
        return categoryService.listByCondition(categoryCondition);
    }

    @PostMapping
    private Result<Category> add(@RequestBody Category category){
        this.categoryService.save(category);
        return ResultUtil.success();
    }

    @GetMapping("/id/{id}")
    private Result<Category> getById(@PathVariable Long id){
        return ResultUtil.success(categoryService.getById(id));
    }

    @PutMapping
    private Result<Category> update(@RequestBody Category category) {
        categoryService.save(category);
        return ResultUtil.success(category);
    }

    @DeleteMapping("/id/{id}")
    private Result<Category> deleteById(@PathVariable Long id){
        categoryService.deleteById(id);
        return ResultUtil.success();
    }
}
