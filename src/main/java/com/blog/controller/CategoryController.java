package com.blog.controller;

import com.blog.condition.CategoryCondition;
import com.blog.domain.Category;
import com.blog.service.CategoryService;
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

}
