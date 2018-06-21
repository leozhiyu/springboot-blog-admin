package com.blog.vo;

import com.blog.domain.Article;

public class ArticleAndTagVO extends Article {

    private Long preId;

    private Long atfId;


    public Long getPreId() {
        return preId;
    }

    public void setPreId(Long preId) {
        this.preId = preId;
    }

    public Long getAtfId() {
        return atfId;
    }

    public void setAtfId(Long atfId) {
        this.atfId = atfId;
    }
}
