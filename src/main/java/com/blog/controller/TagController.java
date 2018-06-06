package com.blog.controller;

import com.blog.condition.CategoryCondition;
import com.blog.condition.TagCondition;
import com.blog.domain.Category;
import com.blog.domain.Result;
import com.blog.domain.Tag;
import com.blog.service.CategoryService;
import com.blog.service.TagService;
import com.blog.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/tag")
public class TagController {

    @Autowired
    TagService tagService;

    @GetMapping(value = "/page")
    private Page<Tag> page(@ModelAttribute TagCondition tagCondition){
        return tagService.listByCondition(tagCondition);
    }

    @PostMapping
    private Result<Tag> add(@RequestBody Tag tag){
        this.tagService.save(tag);
        return ResultUtil.success();
    }

    @GetMapping("/id/{id}")
    private Result<Tag> getById(@PathVariable Long id){
        return ResultUtil.success(tagService.getById(id));
    }

    @PutMapping
    private Result<Tag> update(@RequestBody Tag tag) {
        tagService.save(tag);
        return ResultUtil.success(tag);
    }

    @DeleteMapping("/id/{id}")
    private Result<Tag> deleteById(@PathVariable Long id){
        tagService.deleteById(id);
        return ResultUtil.success();
    }
}
