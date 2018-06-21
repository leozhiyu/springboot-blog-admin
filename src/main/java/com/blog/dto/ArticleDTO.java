package com.blog.dto;

import com.blog.domain.Article;
import lombok.Data;

import java.util.ArrayList;

/**
 * @author: yukong
 * @date: 2018/6/8 14:16
 * @description:
 */
@Data
public class ArticleDTO extends Article {

    private ArrayList<Long> tagIds ;

    private Long categoryId;


}
