package com.blog.dto;

import lombok.Data;

/**
 * @author: yukong
 * @date: 2018/6/11 11:21
 * @description:
 */
@Data
public class TagDTO {

    private Long id;

    private String tagName;

    private Integer count;
}
