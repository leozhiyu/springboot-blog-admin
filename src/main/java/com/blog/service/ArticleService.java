package com.blog.service;

import com.blog.condition.ArticleCondition;
import com.blog.condition.TagCondition;
import com.blog.domain.Article;
import com.blog.domain.Tag;
import com.blog.dto.ArchiveDTO;
import com.blog.dto.ArticleDTO;
import org.springframework.data.domain.Page;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: yukong
 * @date: 2018/6/7 10:14
 * @description:
 */
public interface ArticleService {

    /**
     * 分页查询
     * @param articleCondition
     * @return
     */
    Page<Article> listByCondition(ArticleCondition articleCondition);


    /**
     * 添加标签
     * @param article
     */
    void save (ArticleDTO article);

    /**
     * 主键查询
     * @param id
     * @return
     */
    Article getById(Long id);

    /**
     * 主键删除
     * @param id
     */
    void deleteById(Long id);


    /**
     * 归档查询
     * @return
     */
    List<ArchiveDTO> archive();

    /**
     * 根据年份分组查询
     * @return
     */
    Map<String,List<Article>> findAllGroupByYear();

}
