package com.blog.service.impl;

import com.blog.condition.CategoryCondition;
import com.blog.domain.Category;
import com.blog.responsitory.CategoryRepository;
import com.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Page<Category> listByCondition(CategoryCondition categoryCondition, Sort sort) {
        Specification<Category> specification = new Specification<Category>() {
            @Override
            public Predicate toPredicate(Root<Category> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<Predicate>();
                //参数非空判断。不为空则加此条件
                if (!categoryCondition.getCategoryName().isEmpty()) {
                    Predicate _name = criteriaBuilder.like(root.get("categoryName"),"%"+categoryCondition.getCategoryName()+"%");
                    predicates.add(_name);
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[]{}));
            }
        };
        Pageable pageable = new PageRequest(categoryCondition.getCurrPage(), categoryCondition.getPageSize(),sort);
        return categoryRepository.findAll(specification,pageable);
    }
}
