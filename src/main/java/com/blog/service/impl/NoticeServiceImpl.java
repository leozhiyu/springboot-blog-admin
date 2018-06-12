/**
 * @author:Leo
 * @create 2018/6/11
 * @desc
 */
package com.blog.service.impl;

import com.blog.condition.NoticeCondition;
import com.blog.domain.Notice;
import com.blog.dto.NoticeDTO;
import com.blog.responsitory.NoticeRepository;
import com.blog.service.NoticeService;
import com.blog.util.BeanUtil;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeRepository noticeRepository;

    private EntityManagerFactory emf;

    @Override
    public Page<Notice> listByCondition(NoticeCondition noticeCondition) {
        Sort.Order modifyTimeOrder = new Sort.Order(Sort.Direction.DESC, "modifyTime");
        Sort sort = new Sort(modifyTimeOrder);
        Specification<Notice> specification = ((root, criteriaQuery, criteriaBuilder)->{
            List<Predicate> predicates = new ArrayList<>();
            if (!StringUtils.isEmpty(noticeCondition.getNoticeTitle())) {
                Predicate _name = criteriaBuilder.like(root.get("noticeTitle"), "%" + noticeCondition.getNoticeTitle() + "%");
                predicates.add(_name);
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[]{}));
        });

        Pageable pageable = new PageRequest(noticeCondition.getCurrPage(), noticeCondition.getPageSize(), sort);
        return noticeRepository.findAll(specification, pageable);
    }

    @Override
    public void save(Notice notice) {
        noticeRepository.save(notice);
    }

    @Override
    public Notice getById(Long id) {
        return noticeRepository.findOne(id);
    }

    @Override
    public void deleteById(Long id) {
        noticeRepository.delete(id);
    }

    @Override
    public List<NoticeDTO> findAll() {
        Query query = emf.createEntityManager().createNativeQuery(
                "select id, notice_title, notice_content, creat_time, modify_time from tb_notice ORDER  by creat_time");
        query.unwrap(SQLQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List<Map<String,Object>> rows = query.getResultList();
        List<NoticeDTO> dtos = BeanUtil.transMap2Bean(rows,NoticeDTO.class);
        return dtos;
    }

    @Override
    public Notice getLatest() {
        // todo 如何查第一条数据
         Query query = emf.createEntityManager().createNativeQuery(
                "select id, notice_title, notice_content, creat_time, modify_time " +
                " from tb_notice ORDER  by creat_time " +
                        "limit 1");
        query.unwrap(SQLQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List<Map<String,Object>> rows = query.getResultList();
        List<Notice> dtos = BeanUtil.transMap2Bean(rows,Notice.class);
        return dtos.get(0);
    }
}
