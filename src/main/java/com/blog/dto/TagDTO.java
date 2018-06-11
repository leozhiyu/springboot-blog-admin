package com.blog.dto;

/**
 * @author: yukong
 * @date: 2018/6/11 11:21
 * @description:
 */
public class TagDTO {

    private Long id;

    private String tagName;

    private Integer count;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
