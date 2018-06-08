package com.blog.dto;

import com.blog.domain.Category;

import java.util.Date;

/**
 * @author: yukong
 * @date: 2018/6/8 10:13
 * @description:
 */
public class CategoryDTO   {

    private Long id ;

    private String categoryName;

    private Integer categoryWeight;

    private Date createTime;

    private Integer count;

    private Date modifyTime;

    public CategoryDTO(Long id, String categoryName, Integer categoryWeight, Date createTime, Integer count, Date modifyTime) {
        this.id = id;
        this.categoryName = categoryName;
        this.categoryWeight = categoryWeight;
        this.createTime = createTime;
        this.count = count;
        this.modifyTime = modifyTime;
    }

    public CategoryDTO() {

    }

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}
