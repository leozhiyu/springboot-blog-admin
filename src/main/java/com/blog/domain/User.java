/**
 * @author:Leo
 * @create 2018/4/24
 * @desc
 * 博客用户
 */
package com.blog.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 标记为实体以及对应的表，如果不加此注解，即使在yml配置了jpa也不会生效
 */
@Data
@Entity
@Table(name = "tb_user")
public class User {

    /**
     * 标记为id以及自动增长，注意导入的是jpa中的包
     */
    @Id
    @GeneratedValue
    @Column(columnDefinition = "int COMMENT '主键id'")
    private Integer userId;

    @Column(columnDefinition = "varchar(30) COMMENT '用户名'", unique = true)
    @NotNull(message = "用户名不能为空")
    private String userName;

    @Column(columnDefinition = "varchar(30) COMMENT '邮箱'")
    @NotNull(message = "邮箱不能为空")
    private String userEmail;

    @Column(columnDefinition = "varchar(255) COMMENT '密码'")
    @NotNull(message = "密码不能为空")
    private String userPwd;

    @Column(columnDefinition = "varchar(30) COMMENT 'open_id'")
    private String userOpenId;

    @Column(columnDefinition = "varchar(30) COMMENT '微信'")
    private String userWechat;

    @Column(columnDefinition = "varchar(30) COMMENT 'QQ'")
    private String userQq;

    @Column(columnDefinition = "varchar(30) COMMENT '微博'")
    private String userWeibo;

    @Column(columnDefinition = "varchar(30) COMMENT 'GitHub'")
    private String userGithub;

    @Column(columnDefinition = "blob COMMENT '用户头像'")
    private byte[] userIcon;

    @Column(columnDefinition = "varchar(255) COMMENT '个性签名'")
    private String userSignature;

    @Column(columnDefinition = "text COMMENT '关于我'")
    private String userAbout;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(columnDefinition = "datetime COMMENT '创建时间'")
    private Date createTime;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @Column(columnDefinition = "datetime COMMENT '修改时间'")
    private Date modifyTime;


}
