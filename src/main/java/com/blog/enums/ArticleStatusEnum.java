package com.blog.enums;

/**
 * @author: yukong
 * @date: 2018/6/7 10:38
 * @description:
 */
public enum ArticleStatusEnum {

    RECOVER(-1, "回收"),
    DRAFT(0, "草稿"),
    PUBLISH(1,"发布");

    private Integer code;
    private String msg;

    ArticleStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
