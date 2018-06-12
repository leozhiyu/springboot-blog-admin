package com.blog.service.impl;

import com.blog.condition.CategoryCondition;
import com.blog.domain.Category;
import com.blog.dto.CategoryDTO;
import com.blog.responsitory.CategoryRepository;
import com.blog.service.CategoryService;
import com.blog.util.BeanUtil;
import com.blog.vo.CategoryVO;
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

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    private EntityManagerFactory emf;

    @PersistenceUnit
    public void setEntityManagerFactory(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public Page<Category> listByCondition(CategoryCondition categoryCondition) {
        Sort.Order modifyTimeOrder = new Sort.Order(Sort.Direction.DESC, "modifyTime");
        Sort.Order categoryWeightOrder = new Sort.Order(Sort.Direction.DESC, "categoryWeight");
        ArrayList<Sort.Order> orderList = new ArrayList();
        orderList.add(categoryWeightOrder);
        orderList.add(modifyTimeOrder);
        Sort sort = new Sort(orderList);
        Specification<Category> specification = ((root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<Predicate>();
            //参数非空判断。不为空则加此条件
            if (!StringUtils.isEmpty(categoryCondition.getCategoryName())) {
                Predicate _name = criteriaBuilder.like(root.get("categoryName"), "%" + categoryCondition.getCategoryName() + "%");
                predicates.add(_name);
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[]{}));
        });
        Pageable pageable = new PageRequest(categoryCondition.getCurrPage(), categoryCondition.getPageSize(), sort);
        return categoryRepository.findAll(specification, pageable);
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public Category getById(Long id) {
        return categoryRepository.findOne(id);
    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.delete(id);
    }

    @Override
    public List<CategoryDTO> findAll() {
        EntityManager manager = emf.createEntityManager();
        Query query = manager.createNativeQuery(
                "SELECT tb.*,( SELECT count( * ) count FROM  tb_article ta WHERE  ta.category_id = tb.id )  count FROM tb_category tb");
        query.unwrap(SQLQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List<Map<String,Object>> rows = query.getResultList();
        List<CategoryDTO> dtos = BeanUtil.transMap2Bean(rows,CategoryDTO.class);
        manager.close();
        return dtos;
    }

    @Override
    public List<CategoryDTO> findByCondition(CategoryCondition categoryCondition) {
        EntityManager manager = emf.createEntityManager();
        Query query = manager.createNativeQuery(
                "SELECT tb.*,( SELECT count( * ) count FROM  tb_article ta WHERE  ta.category_id = tb.id )  " +
                        "count FROM tb_category tb where tb.category_name=?").setParameter(1,categoryCondition.getCategoryName());
        query.unwrap(SQLQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List<Map<String,Object>> rows = query.getResultList();
        List<CategoryDTO> dtos = BeanUtil.transMap2Bean(rows,CategoryDTO.class);
        manager.close();
        return dtos;
    }
}
