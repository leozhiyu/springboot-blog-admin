/**
 * @author:Leo
 * @create 2018/4/24
 * @desc Result类只作为一个实体类，用此工具类来实现Result的具体功能比较直观，而不是每次直接给 Result 设置值
 */
package com.blog.util;

import com.blog.domain.Result;
import com.blog.enums.ResultEnum;

public class ResultUtil {


    public static Result success() {
        return new Result(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMsg(), ResultEnum.SUCCESS.getMsg());
    }

    /**
     * 使用默认给出的成功响应，只需要填充数据即可
     * @param object
     * @return
     */
    public static Result success(Object object) {
        return new Result(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMsg(), object);
    }

    /**
     * 自定义成功响应提示
     * @param msg
     * @param object
     * @return
     */
    public static Result success(String msg, Object object) {
        return new Result(ResultEnum.SUCCESS.getCode(), msg, object);
    }

    /**
     * 使用默认的失败响应码，自定义错误提示，数据为空
     * @param msg
     * @return
     */
    public static Result error(String msg) {
        return new Result(ResultEnum.ERROR.getCode(), msg, null);
    }

    /**
     * 自定义的错误码和错误提示，数据为空
     * @param code
     * @param msg
     * @return
     */
    public static Result error(Integer code, String msg) {
        return new Result(code, msg, null);
    }
}
