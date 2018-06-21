package com.blog.service;

import com.blog.condition.ArticleCondition;
import com.blog.condition.TagCondition;
import com.blog.domain.Article;
import com.blog.domain.Tag;
import com.blog.dto.ArchiveDTO;
import com.blog.dto.ArticleDTO;
import com.blog.vo.ArticleAndTagVO;
import com.blog.vo.ArticleVO;
import org.springframework.data.domain.Page;

import java.util.*;

/**
 * @author: yukong
 * @date: 2018/6/7 10:14
 * @description:
 */
public interface ArticleService {

    /**
     * 分页查询
     *
     * @param articleCondition
     * @return
     */
    Page<Article> listByCondition(ArticleCondition articleCondition);


    /**
     * 添加标签
     *
     * @param article
     */
    void save(ArticleDTO article);

    /**
     * 主键查询
     *
     * @param id
     * @return
     */
    Article getById(Long id);

    /**
     * 主键查询
     * 带上下文章id
     * @param id
     * @return
     */
    ArticleAndTagVO getVoById(Long id);

    /**
     * 主键删除
     *
     * @param id
     */
    void deleteById(Long id);


    /**
     * 归档查询
     *
     * @return
     */
    List<ArchiveDTO> archive();

    /**
     * 根据年份分组查询
     *
     * @return
     */
    LinkedHashMap<Integer, List<Article>> findAllGroupByYear();


    /**
     * 根据年月查询
     *
     * @param year
     * @param month
     * @return
     */
    LinkedHashMap<Integer, List<Article>> findByYearAndMonth(Integer year, Integer month);


    /**
     * 根据类目名称分组
     *
     * @return
     */
    Map<String, List<Article>> findArticleGroupByCategory();

    /**
     * 根据类目名称分组
     *
     * @param categoryName 分组条件
     * @return
     */
    Map<String, List<Article>> findArticleGroupByCategory(String categoryName);

    /**
     * 根据标签名称分组
     *
     * @return
     */
    Map<String, Set<Article>> findArticleGroupByTag();

    /**
     * 根据标签名称分组
     *
     * @param tagName 分组条件
     * @return
     */
    Map<String, Set<Article>> findArticleGroupByTag(String tagName);
}


