package com.blog.service;


import com.blog.condition.CategoryCondition;
import com.blog.domain.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface CategoryService {

    /**
     * 分页查询
     * @param categoryCondition
     * @param sort
     * @return
     */
    Page<Category> listByCondition(CategoryCondition categoryCondition, Sort sort);

}
