package com.blog.service.impl;

import com.blog.condition.TagCondition;
import com.blog.domain.Category;
import com.blog.domain.Tag;
import com.blog.responsitory.TagRepository;
import com.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: yukong
 * @date: 2018/6/6 15:27
 * @description:
 */
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagRepository tagRepository;


    @Override
    public Page<Tag> listByCondition(TagCondition tagCondition) {
        Sort.Order modifyTimeOrder = new Sort.Order(Sort.Direction.DESC,"modifyTime");
        Sort sort = new Sort(modifyTimeOrder);
        Specification<Tag> specification =((root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<Predicate>();
            if (!StringUtils.isEmpty(tagCondition.getTagName())) {
                Predicate _name = criteriaBuilder.like(root.get("tagName"),"%"+tagCondition.getTagName()+"%");
                predicates.add(_name);
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[]{}));
        });

        Pageable pageable = new PageRequest(tagCondition.getCurrPage(), tagCondition.getPageSize(),sort);
        return tagRepository.findAll(specification,pageable);
    }

    @Override
    public void save(Tag tag) {
        tagRepository.save(tag);
    }

    @Override
    public Tag getById(Long id) {
        return tagRepository.findOne(id);
    }

    @Override
    public void deleteById(Long id) {
        tagRepository.delete(id);
    }

    @Override
    public List<Tag> findAll() {
        return tagRepository.findAll();
    }
}
