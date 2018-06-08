package com.blog.dto;

import com.blog.domain.Article;

import java.util.ArrayList;

/**
 * @author: yukong
 * @date: 2018/6/8 14:16
 * @description:
 */
public class ArticleDTO extends Article {

    private ArrayList<Long> tagIds ;

    private Long categoryId;


    public ArrayList<Long> getTagIds() {
        return tagIds;
    }

    public void setTagIds(ArrayList<Long> tagIds) {
        this.tagIds = tagIds;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
