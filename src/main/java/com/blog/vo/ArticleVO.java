package com.blog.vo;

import java.util.Date;

/**
 * @author: yukong
 * @date: 2018/6/12 10:48
 * @description:
 */
public class ArticleVO {

    private Long id ;

    private String articleTitle;

    private Date publishTime;

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

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }
}
