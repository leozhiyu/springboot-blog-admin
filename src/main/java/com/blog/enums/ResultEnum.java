/**
 * @author:Leo
 * @create 2018/4/24
 * @desc
 */
package com.blog.enums;

public enum  ResultEnum {
    SUCCESS(1, "成功"),
    ERROR(-1, "失败");

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
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
