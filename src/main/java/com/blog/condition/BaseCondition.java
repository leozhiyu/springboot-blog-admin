package com.blog.condition;

/**
 * 基类
 */
public class BaseCondition {

    private final Integer currPage = 0;

    private final Integer pageSize = 10;

    public Integer getCurrPage() {
        return currPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }
}
