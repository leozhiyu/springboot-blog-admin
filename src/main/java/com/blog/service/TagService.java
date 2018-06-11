package com.blog.service;

import com.blog.condition.CategoryCondition;
import com.blog.condition.TagCondition;
import com.blog.domain.Category;
import com.blog.domain.Tag;
import com.blog.dto.TagDTO;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author: yukong
 * @date: 2018/6/6 15:25
 * @description:
 */
public interface TagService {


    /**
     * 分页查询
     * @param tagCondition
     * @return
     */
    Page<Tag> listByCondition(TagCondition tagCondition);


    /**
     * 添加标签
     * @param tag
     */
    void save (Tag tag);

    /**
     * 主键查询
     * @param id
     */
    Tag getById(Long id);

    /**
     * 主键删除
     * @param id
     */
    void deleteById(Long id);


    /**
     * 查询所有标签
     * @return
     */
    List<Tag> findAll();

    /**
     * 查询所有标签以及每个标签文章的数量
     * @return
     */
    List<TagDTO> findAllAndCount();
}
