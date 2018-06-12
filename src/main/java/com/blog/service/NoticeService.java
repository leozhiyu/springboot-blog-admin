package com.blog.service;

import com.blog.condition.NoticeCondition;
import com.blog.domain.Notice;
import com.blog.dto.NoticeDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface NoticeService {
    /**
     * 分页查询
     * @param noticeCondition
     * @return
     */
    Page<Notice> listByCondition(NoticeCondition noticeCondition);

    /**
     * 添加公告
     */
    void save (Notice notice);

    /**
     * 主键查询
     * @param id
     */
    Notice getById(Long id);

    /**
     * 主键删除
     * @param id
     */
    void deleteById(Long id);

    /**
     * 查询所有公告
     * @return
     */
    List<NoticeDTO> findAll();

    /**
     * 查找最新的公告
     * @return
     */
    Notice getLatest();
}
