package com.blog.domain;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author: yukong
 * @date: 2018/6/7 09:47
 * @description: 文章表
 */

@Entity
@Table(name = "tb_article")
public class Article {


    @Id
    @GeneratedValue
    @Column(columnDefinition = "bigint COMMENT '主键id'")
    private Long id ;

    @Column(columnDefinition = "varchar(30) COMMENT '文章标题'")
    @NotNull(message = "文章标题不能为空")
    private String articleTitle;

    @Lob
    @Column(columnDefinition = "text COMMENT '文章标题'")
    @NotNull(message = "文章内容不能为空")
    private String articleContent;


    @Column(columnDefinition = "int  default 0  COMMENT '文章状态 0 草稿 1 已发布 -1 已回收'")
    private Integer articleStatus;


    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(columnDefinition = "datetime COMMENT '创建时间'")
    private Date createTime;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @Column(columnDefinition = "datetime COMMENT '修改时间'")
    private Date modifyTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(columnDefinition = "datetime COMMENT '发布时间'")
    private Date publishTime;

    @NotNull(message = "所属类别不能为空")
    @Column(columnDefinition = "varchar(50) COMMENT '所属类别'")
    private String categoryList;

    @NotNull(message = "所属标签不能为空")
    @Column(columnDefinition = "varchar(50) COMMENT '所属标签'")
    private String tagList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public Integer getArticleStatus() {
        return articleStatus;
    }

    public void setArticleStatus(Integer articleStatus) {
        this.articleStatus = articleStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public String getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(String categoryList) {
        this.categoryList = categoryList;
    }

    public String getTagList() {
        return tagList;
    }

    public void setTagList(String tagList) {
        this.tagList = tagList;
    }
}
