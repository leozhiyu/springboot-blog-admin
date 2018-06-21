package com.blog.dto;

import com.blog.domain.Category;
import lombok.Data;

import java.util.Date;

/**
 * @author: yukong
 * @date: 2018/6/8 10:13
 * @description:
 */
@Data
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


}
