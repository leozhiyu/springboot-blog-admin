package com.blog.controller.front;

import com.blog.domain.Category;
import com.blog.domain.Tag;
import com.blog.dto.CategoryDTO;
import com.blog.service.CategoryService;
import com.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

  /*  @GetMapping("/category")
    List<Map> findAllCategory(){
        return categoryService.findAll();
    }
*/
    @GetMapping("/tag")
    List<Tag> findAllTag() {
        return tagService.findAll();
    }

}
