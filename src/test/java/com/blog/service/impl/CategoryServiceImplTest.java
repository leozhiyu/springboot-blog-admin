package com.blog.service.impl;

import com.blog.condition.CategoryCondition;
import com.blog.domain.Category;
import com.blog.service.CategoryService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

    @Autowired
    private CategoryService categoryService;


    @Test
    public void listByCondition() throws JsonProcessingException {


        CategoryCondition categoryCondition = new CategoryCondition();
        categoryCondition.setCategoryName("java");
        Page<Category> page = categoryService.listByCondition(categoryCondition);
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(page));


    }
}