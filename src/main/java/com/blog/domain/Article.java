package com.blog.domain;

import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

/**
 * @author: yukong
 * @date: 2018/6/7 09:47
 * @description: 文章表
 */

@Entity
@Table(name = "tb_article")
public class Article {

    public interface ArticleYearView{}


    @Id
    @GeneratedValue
    @Column(columnDefinition = "bigint COMMENT '主键id'")
    @JsonView(Article.ArticleYearView.class)
    private Long id ;

    @Column(columnDefinition = "varchar(30) COMMENT '文章标题'")
    @NotNull(message = "文章标题不能为空")
    @JsonView(Article.ArticleYearView.class)
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
    @JsonView(Article.ArticleYearView.class)
    private Date publishTime;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "article_tag", joinColumns = {
            @JoinColumn(name = "article_id", referencedColumnName = "id")}, inverseJoinColumns = {
            @JoinColumn(name = "tag_id", referencedColumnName = "id")})
    private Set<Tag> tags;

    @OneToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="category_id")
    private Category category;

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



    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public String groupByYear(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
        return simpleDateFormat.format(this.getPublishTime());
    }
}
