/**
 * @author:Leo
 * @create 2018/4/24
 * @desc
 * 博客用户
 */
package com.blog.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

//标记为实体以及对应的表，如果不加此注解，即使在yml配置了jpa也不会生效
@Entity
@Table(name = "tb_user")
public class User {

    @Id //标记为id以及自动增长，注意导入的是jpa中的包
    @GeneratedValue
    @Column(columnDefinition = "int COMMENT '主键id'")
    private Integer userId;

    /**用户名*/
    @Column(columnDefinition = "varchar(30) COMMENT '用户名'")
    @NotNull(message = "用户名不能为空")
    private String userName;

    /**用户邮箱*/

    @Column(columnDefinition = "varchar(30) COMMENT '邮箱'")
    @NotNull(message = "邮箱不能为空")
    private String userEmail;

    /**登录密码*/
    @Column(columnDefinition = "varchar(30) COMMENT '密码'")
    @NotNull(message = "密码不能为空")
    private String userPwd;

    /**open_id*/
    @Column(columnDefinition = "varchar(30) COMMENT 'open_id'")
    private String userOpenId;

    /**微信*/
    @Column(columnDefinition = "varchar(30) COMMENT '微信'")
    private String userWechat;

    /**QQ*/
    @Column(columnDefinition = "varchar(30) COMMENT 'QQ'")
    private String userQq;

    /**微博*/
    @Column(columnDefinition = "varchar(30) COMMENT '微博'")
    private String userWeibo;

    /**GitHub*/
    @Column(columnDefinition = "varchar(30) COMMENT 'GitHub'")
    private String userGithub;

    /**用户头像*/
    @Column(columnDefinition = "blob COMMENT '用户头像'")
    private byte[] userIcon;

    /**个性签名*/
    @Column(columnDefinition = "varchar(255) COMMENT '个性签名'")
    private String userSignature;

    /**关于我*/
    @Column(columnDefinition = "text COMMENT '关于我'")
    private String userAbout;

    /**用户创建时间*/
    @Column(columnDefinition = "datetime COMMENT '创建时间'")
    private Date createTime;

    /**用户信息修改时间*/
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
