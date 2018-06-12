/**
 * @author:Leo
 * @create 2018/4/24
 * @desc JsonResult，统一返回结果给前端接口调用
 */
package com.blog.domain;

import com.fasterxml.jackson.annotation.JsonView;

public class Result<T> {
    /**响应码*/
    @JsonView(Article.SimpleArticleView.class)
    private Integer code;

    /**响应提示*/
    @JsonView(Article.SimpleArticleView.class)

    private String msg;

    /**返回的数据*/
    @JsonView(Article.SimpleArticleView.class)
    private T data;

    public Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
