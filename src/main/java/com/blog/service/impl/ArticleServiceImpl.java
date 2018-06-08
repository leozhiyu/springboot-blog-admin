package com.blog.service.impl;

import com.blog.condition.ArticleCondition;
import com.blog.domain.Article;
import com.blog.domain.Tag;
import com.blog.enums.ArticleStatusEnum;
import com.blog.responsitory.ArticleRepository;
import com.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author: yukong
 * @date: 2018/6/7 10:30
 * @description:
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public Page<Article> listByCondition(ArticleCondition articleCondition) {
        Sort.Order modifyTimeOrder = new Sort.Order(Sort.Direction.DESC,"modifyTime");
        Sort sort = new Sort(modifyTimeOrder);
        Specification<Article> specification =((root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<Predicate>();
            if (!StringUtils.isEmpty(articleCondition.getArticleTitle())) {
                Predicate _name = criteriaBuilder.like(root.get("articleTitle"),"%"+articleCondition.getArticleTitle()+"%");
                predicates.add(_name);
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[]{}));
        });

        Pageable pageable = new PageRequest(articleCondition.getCurrPage(), articleCondition.getPageSize(),sort);
        return articleRepository.findAll(specification,pageable);
    }

    @Override
    public void save(Article article) {
        if (article.getId() != null && ArticleStatusEnum.PUBLISH.getCode().equals(article.getArticleStatus())){

        } else {
            article.setPublishTime(new Date());
        }
        articleRepository.save(article);
    }

    @Override
    public Article getById(Long id) {
        return articleRepository.findOne(id);
    }

    @Override
    public void deleteById(Long id) {
        articleRepository.delete(id);
    }
}
