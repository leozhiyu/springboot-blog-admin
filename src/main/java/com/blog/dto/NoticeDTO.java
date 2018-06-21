/**
 * @author:Leo
 * @create 2018/6/11
 * @desc
 */
package com.blog.dto;

import lombok.Data;

import java.util.Date;

@Data
public class NoticeDTO {

    private Long id;

    private String noticeTitle;

    private String noticeContent;

    private Date creatTime;

    private Date modifyTime;

    public NoticeDTO(Long id, String noticeTitle, String noticeContent, Date creatTime, Date modifyTime) {
        this.id = id;
        this.noticeTitle = noticeTitle;
        this.noticeContent = noticeContent;
        this.creatTime = creatTime;
        this.modifyTime = modifyTime;
    }
    public NoticeDTO(){}

}
