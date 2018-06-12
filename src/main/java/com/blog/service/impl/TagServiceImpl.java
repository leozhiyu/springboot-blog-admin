package com.blog.service.impl;

import com.blog.condition.TagCondition;
import com.blog.domain.Tag;
import com.blog.dto.TagDTO;
import com.blog.responsitory.TagRepository;
import com.blog.service.TagService;
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
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author: yukong
 * @date: 2018/6/6 15:27
 * @description:
 */
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagRepository tagRepository;

    private EntityManagerFactory emf;

    @PersistenceUnit
    public void setEntityManagerFactory(EntityManagerFactory emf) {
        this.emf = emf;
    }

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

    @Override
    public List<TagDTO> findAllAndCount() {
        Query query = emf.createEntityManager().createNativeQuery(
                " SELECT " +
                            "a.*, " +
                            "b.*  " +
                         "FROM " +
                            "tb_tag a, " +
                            "( " +
                            " SELECT " +
                            "tag_id, " +
                            "count( * ) count " +
                            "FROM " +
                            "article_tag " +
                            "GROUP BY " +
                            "tag_id  " +
                            ") b  " +
                            "WHERE " +
                            "a.id = b.tag_id " +
                            "order by a.modify_time desc ");
        query.unwrap(SQLQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List<Map<String,Object>> rows = query.getResultList();
        List<TagDTO> dtos = BeanUtil.transMap2Bean(rows,TagDTO.class);
        emf.close();
        return dtos;
    }


}
