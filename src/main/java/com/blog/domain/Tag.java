package com.blog.domain;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author: yukong
 * @date: 2018/6/6 14:52
 * @description:
 */
@Entity
@Table(name = "tb_tag")
public class Tag {
    /**
     * 标记为id以及自动增长，注意导入的是jpa中的包
     */
    @Id
    @GeneratedValue
    @Column(columnDefinition = "bigint COMMENT '主键id'")
    private Long id;


    @Column(columnDefinition = "varchar(30) COMMENT '类目名称'", unique = true)
    @NotNull(message = "标签名不能为空")
    private String tagName;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(columnDefinition = "datetime COMMENT '创建时间'")
    private Date createTime;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @Column(columnDefinition = "datetime COMMENT '修改时间'")
    private Date modifyTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}