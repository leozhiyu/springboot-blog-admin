/**
 * @author:Leo
 * @create 2018/4/24
 * @desc
 */
package com.blog.handle;

import com.blog.domain.Result;
import com.blog.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理器，用于拦截抛出的异常做 Json 格式化处理，防止返回不同格式的结果
 */
@ControllerAdvice
public class ExceptionHandle {

    private static Logger LOGGER = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        e.printStackTrace();
        LOGGER.error("【系统异常】 {}", e.getMessage());
        return ResultUtil.error(e.getMessage());
    }
}
