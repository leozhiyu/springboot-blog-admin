package com.blog.vo;

import com.blog.domain.Article;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: yukong
 * @date: 2018/6/12 10:41
 * @description:
 */
public class CategoryVO {

    private Long id ;

    private String categoryName;

    private Integer categoryWeight;

    private Set<ArticleVO> items = new HashSet<ArticleVO>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getCategoryWeight() {
        return categoryWeight;
    }

    public void setCategoryWeight(Integer categoryWeight) {
        this.categoryWeight = categoryWeight;
    }

    public Set<ArticleVO> getItems() {
        return items;
    }

    public void setItems(Set<ArticleVO> items) {
        this.items = items;
    }
}
