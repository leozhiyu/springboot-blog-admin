/**
 * @author:Leo
 * @create 2018/6/11
 * @desc 公告管理
 */
package com.blog.controller;

import com.blog.condition.NoticeCondition;
import com.blog.domain.Notice;
import com.blog.domain.Result;
import com.blog.service.NoticeService;
import com.blog.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/notice")
public class NoticeController {
    @Autowired
    NoticeService noticeService;

    @GetMapping("/page")
    private Page<Notice> page(@ModelAttribute NoticeCondition noticeCondition) {
        return noticeService.listByCondition(noticeCondition);
    }

    @PostMapping
    private Result<Notice> add(@RequestBody Notice notice) {
        noticeService.save(notice);
        return ResultUtil.success();
    }

    @GetMapping("/id/{id}")
    private Result<Notice> getById(@PathVariable Long id) {
        return ResultUtil.success(noticeService.getById(id));
    }

    @PutMapping
    private Result<Notice> update(@RequestBody Notice notice) {
        noticeService.save(notice);
        return ResultUtil.success(notice);
    }

    @DeleteMapping("/id/{id}")
    private Result<Notice> deleteById(@PathVariable Long id) {
        noticeService.deleteById(id);
        return ResultUtil.success();
    }
}
