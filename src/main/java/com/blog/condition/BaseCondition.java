package com.blog.condition;

/**
 * 基类
 */
public class BaseCondition {

    private  Integer currPage ;

    private  Integer pageSize ;

    public Integer getCurrPage() {
        return currPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setCurrPage(Integer currPage) {
        this.currPage = currPage;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
