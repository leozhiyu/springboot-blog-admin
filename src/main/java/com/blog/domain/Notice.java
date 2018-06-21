/**
 * @author:Leo
 * @create 2018/6/11
 * @desc
 */
package com.blog.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity
@Table(name = "tb_notice")
public class Notice {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "bigint COMMENT '主键id'")
    private Long id;

    @Column(columnDefinition = "varchar(30) COMMENT '公告标题'")
    @NotNull(message = "公告标题不能为空")
    private String noticeTitle;

    @Column(columnDefinition = "text COMMENT '公告内容'")
    @NotNull(message = "公告内容不能为空")
    private String noticeContent;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(columnDefinition = "datetime COMMENT '创建时间'")
    @CreationTimestamp
    private Date creatTime;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @Column(columnDefinition = "datetime COMMENT '修改时间'")
    private Date modifyTime;


}
