/**
 * @author:Leo
 * @create 2018/6/11
 * @desc
 */
package com.blog.dto;

import java.util.Date;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}
