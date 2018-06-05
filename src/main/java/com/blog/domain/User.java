/**
 * @author:Leo
 * @create 2018/4/24
 * @desc
 * 博客用户
 */
package com.blog.domain;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 标记为实体以及对应的表，如果不加此注解，即使在yml配置了jpa也不会生效
 */
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserOpenId() {
        return userOpenId;
    }

    public void setUserOpenId(String userOpenId) {
        this.userOpenId = userOpenId;
    }

    public String getUserWechat() {
        return userWechat;
    }

    public void setUserWechat(String userWechat) {
        this.userWechat = userWechat;
    }

    public String getUserQq() {
        return userQq;
    }

    public void setUserQq(String userQq) {
        this.userQq = userQq;
    }

    public String getUserWeibo() {
        return userWeibo;
    }

    public void setUserWeibo(String userWeibo) {
        this.userWeibo = userWeibo;
    }

    public String getUserGithub() {
        return userGithub;
    }

    public void setUserGithub(String userGithub) {
        this.userGithub = userGithub;
    }

    public byte[] getUserIcon() {
        return userIcon;
    }

    public void setUserIcon(byte[] userIcon) {
        this.userIcon = userIcon;
    }

    public String getUserSignature() {
        return userSignature;
    }

    public void setUserSignature(String userSignature) {
        this.userSignature = userSignature;
    }

    public String getUserAbout() {
        return userAbout;
    }

    public void setUserAbout(String userAbout) {
        this.userAbout = userAbout;
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
